package com.example.dictionaryapplication.dictionary.domain.repository

import com.example.dictionaryapplication.core.util.Resource
import com.example.dictionaryapplication.dictionary.domain.models.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word:String): Flow<Resource<List<WordInfo>>>
}