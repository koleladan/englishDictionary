package com.example.dictionaryapplication.core.util

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryapplication.dictionary.domain.models.Meaning
import com.example.dictionaryapplication.dictionary.domain.models.WordInfo

@Entity
data class WordInfoEntity(
    val meanings: List<Meaning>,
    val phonetic: String,
    val sourceUrls: List<String>,
    val word: String,
    @PrimaryKey val id: Int? = null
){
    fun toWordInfo(): WordInfo{
        return  WordInfo(
            meanings= meanings,
            phonetic =phonetic,
            word = word,
            sourceUrls = sourceUrls
        )
    }
}
