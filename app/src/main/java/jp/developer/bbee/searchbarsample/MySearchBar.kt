package jp.developer.bbee.searchbarsample.ui.theme

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import jp.developer.bbee.searchbarsample.MainViewModel

@Composable
fun MySearchBar(
    searchText: String = "",
    mainViewModel: MainViewModel = hiltViewModel()
) {
    TopAppBar {
        OutlinedTextField(
            value = mainViewModel.searchText.value,
            onValueChange = {
                mainViewModel.searchText.value = it
            }
        )
    }
}