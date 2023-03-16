package com.example.dictionaryapplication.dictionary.domain.models

data class Meaning(

    val definitions: List<Definition?>,
    val partOfSpeech: String?
)
