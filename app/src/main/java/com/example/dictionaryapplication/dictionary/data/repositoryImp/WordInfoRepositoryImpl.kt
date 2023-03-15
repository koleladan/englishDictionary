package com.example.dictionaryapplication.dictionary.data.repositoryImp

import com.example.dictionaryapplication.core.util.Resource
import com.example.dictionaryapplication.dictionary.data.local.entity.WordInfoDao
import com.example.dictionaryapplication.dictionary.data.remote.dto.DictionaryApi
import com.example.dictionaryapplication.dictionary.domain.models.WordInfo
import com.example.dictionaryapplication.dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException


class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
): WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfos(word).map {
            it.toWordInfo()
        }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })

        }catch (e:HttpException){
            emit(Resource.Error(
               message = "an error occurred!",
               data =  wordInfos
            ))

        } catch (e:IOException){
            emit(Resource.Error(
                message = "Could not reach server, check your internet connection.",
                data =  wordInfos
            ))

        }

        val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfos))

    }

}