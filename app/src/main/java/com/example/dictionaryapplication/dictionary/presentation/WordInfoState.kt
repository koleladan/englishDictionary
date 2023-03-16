package com.example.dictionaryapplication.dictionary.presentation

import com.example.dictionaryapplication.dictionary.domain.models.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading:Boolean = false

)
