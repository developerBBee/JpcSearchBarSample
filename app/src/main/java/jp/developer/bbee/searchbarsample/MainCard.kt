package jp.developer.bbee.searchbarsample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainCard(
    item: Item,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val searchText = mainViewModel.searchText.value
    if (searchText.isNotEmpty()
        && !item.title.contains(searchText)
        && !item.description.contains(searchText)
    ) {
        return
    }
    Card(elevation = 5.dp, modifier = Modifier.padding(5.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = item.title, fontWeight = FontWeight.ExtraBold)
            Text(text = item.description)
        }
    }
}