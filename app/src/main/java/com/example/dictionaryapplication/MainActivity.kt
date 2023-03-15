package com.example.dictionaryapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dictionaryapplication.dictionary.presentation.WordInfoItem
import com.example.dictionaryapplication.dictionary.presentation.WordInfoViewModel
import com.example.dictionaryapplication.ui.theme.DictionaryApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DictionaryApplicationTheme {
                val viewModel:WordInfoViewModel = hiltViewModel()
                val state = viewModel.state.value
                val scaffoldState = rememberScaffoldState()


                LaunchedEffect(key1 = true ){
                    viewModel.eventFlow.collectLatest {  event ->
                        when(event){
                            is WordInfoViewModel.UIEvent.ShowSnackbar ->{
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = event.message
                                )
                            }

                        }

                    }
                }

                Scaffold(
                    scaffoldState = scaffoldState
                ) {
                    Box(modifier = Modifier
                        .background(MaterialTheme.colors.background))
                    {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(18.dp)
                        ) {
                            TextField(
                                value = viewModel.searchQuery.value ,
                                onValueChange =viewModel::onSearch,
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(text = "Search...")
                                }
                            )
                            Spacer(modifier = Modifier.height(13.dp))
                            LazyColumn(
                                modifier = Modifier.fillMaxSize()
                            ){
                                items(state.wordInfoItems.size){i ->
                                    val wordInfo = state.wordInfoItems[i]
                                    if (i>0){
                                        Spacer(modifier = Modifier.height(8.dp))
                                    }
                                    WordInfoItem(wordInfo = wordInfo)
                                    if (i < state.wordInfoItems.size-1){
                                        Divider()
                                    }
                                }

                            }
                            
                        }
                        
                    }

                }



            }
        }
    }
}

