package jp.developer.bbee.searchbarsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import jp.developer.bbee.searchbarsample.ui.theme.MySearchBar
import jp.developer.bbee.searchbarsample.ui.theme.SearchBarSampleTheme
import kotlin.math.pow
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchBarSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val itemList = createItems()
                    Scaffold(
                        topBar = {
                            MySearchBar()
                        }
                    ) {
                        LazyColumn(Modifier.padding(it)) {
                            items(itemList) { item ->
                                Card(elevation = 5.dp, modifier = Modifier.padding(5.dp)) {
                                    Column(modifier = Modifier.fillMaxWidth()) {
                                        Text(text = item.title, fontWeight = FontWeight.ExtraBold)
                                        Text(text = item.description)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    private fun createItems(): List<Item> {
        val items = mutableListOf<Item>()
        for (i in 1..1000) {
            items.add(
                Item(
                    title = "Title$i",
                    description = "Description ${i.toDouble().pow(1.1).roundToInt()}"
                )
            )
        }
        return items
    }
}
