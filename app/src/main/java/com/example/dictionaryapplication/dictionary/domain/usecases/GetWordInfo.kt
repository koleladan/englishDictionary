package com.example.dictionaryapplication.dictionary.domain.usecases

import com.example.dictionaryapplication.core.util.Resource
import com.example.dictionaryapplication.dictionary.domain.models.WordInfo
import com.example.dictionaryapplication.dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator  fun  invoke(word:String): Flow<Resource<List<WordInfo>>>{
        if (word.isBlank()){
            return flow {  }
        }
        return repository.getWordInfo(word)
    }
}