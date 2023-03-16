package com.example.dictionaryapplication.dictionary.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dictionaryapplication.dictionary.domain.models.WordInfo

@Composable
fun WordInfoItem(
    wordInfo: WordInfo,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        wordInfo.word?.let {
            Text(
                text = it,
                fontSize =  24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black

            )
        }
        wordInfo.phonetic?.let {
            Text(
                text = it, fontWeight = FontWeight.Light

            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        wordInfo.origin?.let { Text(text = it) }

        wordInfo.meanings.forEach { meaning ->
            if (meaning != null) {
                meaning.partOfSpeech?.let { Text(text = it, fontWeight = FontWeight.Bold) }
            }
            if (meaning != null) {
                meaning.definitions.forEachIndexed { i, definition ->
                    if (definition != null) {
                        Text(text = "${i + 1}. ${definition.definition}" )
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    if (definition != null) {
                        definition.example?.let { example ->
                            Text(text = "Example: $example")
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))


                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }




    }

}