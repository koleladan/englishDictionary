package com.example.dictionaryapplication.dictionary.data.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [WordInfoEntity::class],
    version = 3
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase:RoomDatabase() {
    abstract val dao: WordInfoDao
}