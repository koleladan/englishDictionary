package com.example.dictionaryapplication.dictionary.domain.models


data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic: String,
    val origin: String,
    val word: String
)
