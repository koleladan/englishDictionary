package com.example.dictionaryapplication.dictionary.data.local.entity

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.dictionaryapplication.dictionary.data.util.JsonParser
import com.example.dictionaryapplication.dictionary.domain.models.Meaning
import com.google.gson.reflect.TypeToken


@ProvidedTypeConverter
class Converters (
    private val jsonParser: JsonParser
        ){
    @TypeConverter
    fun  fromMeaningsJson(json: String): List<Meaning>{
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        )?: emptyList()

    }

    @TypeConverter
    fun toMeaningsJson(meanings:List<Meaning>):String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        )?: "[]"
    }
}