package jp.developer.bbee.searchbarsample.ui.theme

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun MySearchBar(
    searchText: String = ""
) {
    TopAppBar {
        OutlinedTextField(
            value = "",
            onValueChange = {}
        )
    }
}