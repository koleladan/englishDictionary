package com.example.dictionaryapplication.dictionary.data.remote.dto

import com.example.dictionaryapplication.dictionary.data.local.entity.WordInfoEntity

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String,
    val word: String
)
{
    fun toWordInfoEntity(): WordInfoEntity{
        return WordInfoEntity(
            meanings = meanings.map { it. toMeaning() },
            phonetic = phonetic,
            word = word,
            origin = origin

        )
    }

}