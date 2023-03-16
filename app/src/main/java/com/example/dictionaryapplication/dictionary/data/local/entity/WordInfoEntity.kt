package com.example.dictionaryapplication.dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryapplication.dictionary.domain.models.Meaning
import com.example.dictionaryapplication.dictionary.domain.models.WordInfo

@Entity
data class WordInfoEntity(
    val meanings: List<Meaning>,
    val phonetic: String?,
    val word: String?,
    val origin: String?,
    @PrimaryKey val id: Int? = null
){
    //mapper
    fun toWordInfo(): WordInfo{
        return  WordInfo(
            meanings= meanings,
            phonetic =phonetic,
            word = word,
            origin = origin
        )
    }
}
