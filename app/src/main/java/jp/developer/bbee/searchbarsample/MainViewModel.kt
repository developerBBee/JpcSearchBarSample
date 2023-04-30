package jp.developer.bbee.searchbarsample

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val searchText = mutableStateOf("")
}