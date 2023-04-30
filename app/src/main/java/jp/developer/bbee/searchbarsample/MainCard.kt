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
    val list = createSearchList(searchText)
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

fun createSearchList(searchText: String): List<String> {
    return searchText
        .trim()
        .replace("　", " ")
        .split("\\s+".toRegex())
}

fun convertToFullWidthKatakana(input: String): String {
    val sb = StringBuilder()
    for (i in input.indices) {
        val c1 = input[i]
        if (c1 == 'ﾞ' || c1 == 'ﾟ') continue // 濁音、半濁音はskip

        if (i < input.length -1) {
            val c2 = input[i+1]
            val str = c1.toString() + c2.toString()
            if ((c2 == 'ﾞ' || c2 == 'ﾟ') && kanaMap.keys.contains(str)) {
                sb.append(kanaHalfToFullMapping(str))
            } else {
                sb.append(kanaHalfToFullMapping(c1.toString()))
            }
        } else {
            sb.append(kanaHalfToFullMapping(c1.toString()))
        }
    }
    return sb.toString()
}


fun kanaHalfToFullMapping(input: String): String {
    return kanaMap[input] ?: input
}

val kanaMap = mapOf(
    "ｱ" to "ア",
    "ｲ" to "イ",
    "ｳ" to "ウ",
    "ｴ" to "エ",
    "ｵ" to "オ",
    "ｶ" to "カ",
    "ｷ" to "キ",
    "ｸ" to "ク",
    "ｹ" to "ケ",
    "ｺ" to "コ",
    "ｻ" to "サ",
    "ｼ" to "シ",
    "ｽ" to "ス",
    "ｾ" to "セ",
    "ｿ" to "ソ",
    "ﾀ" to "タ",
    "ﾁ" to "チ",
    "ﾂ" to "ツ",
    "ﾃ" to "テ",
    "ﾄ" to "ト",
    "ﾅ" to "ナ",
    "ﾆ" to "ニ",
    "ﾇ" to "ヌ",
    "ﾈ" to "ネ",
    "ﾉ" to "ノ",
    "ﾊ" to "ハ",
    "ﾋ" to "ヒ",
    "ﾌ" to "フ",
    "ﾍ" to "ヘ",
    "ﾎ" to "ホ",
    "ﾏ" to "マ",
    "ﾐ" to "ミ",
    "ﾑ" to "ム",
    "ﾒ" to "メ",
    "ﾓ" to "モ",
    "ﾔ" to "ヤ",
    "ﾕ" to "ユ",
    "ﾖ" to "ヨ",
    "ﾗ" to "ラ",
    "ﾘ" to "リ",
    "ﾙ" to "ル",
    "ﾚ" to "レ",
    "ﾛ" to "ロ",
    "ﾜ" to "ワ",
    "ｦ" to "ヲ",
    "ﾝ" to "ン",
    "ｧ" to "ァ",
    "ｨ" to "ィ",
    "ｩ" to "ゥ",
    "ｪ" to "ェ",
    "ｫ" to "ォ",
    "ｬ" to "ャ",
    "ｭ" to "ュ",
    "ｮ" to "ョ",
    "ｯ" to "ッ",
    "ｰ" to "ー",
    "｡" to "。",
    "｢" to "「",
    "｣" to "」",
    "､" to "、",
    "･" to "・",
    "ｶﾞ" to "ガ",
    "ｷﾞ" to "ギ",
    "ｸﾞ" to "グ",
    "ｹﾞ" to "ゲ",
    "ｺﾞ" to "ゴ",
    "ｻﾞ" to "ザ",
    "ｼﾞ" to "ジ",
    "ｽﾞ" to "ズ",
    "ｾﾞ" to "ゼ",
    "ｿﾞ" to "ゾ",
    "ﾀﾞ" to "ダ",
    "ﾁﾞ" to "ヂ",
    "ﾂﾞ" to "ヅ",
    "ﾃﾞ" to "デ",
    "ﾄﾞ" to "ド",
    "ﾊﾞ" to "バ",
    "ﾋﾞ" to "ビ",
    "ﾌﾞ" to "ブ",
    "ﾍﾞ" to "ベ",
    "ﾎﾞ" to "ボ",
    "ﾊﾟ" to "パ",
    "ﾋﾟ" to "ピ",
    "ﾌﾟ" to "プ",
    "ﾍﾟ" to "ペ",
    "ﾎﾟ" to "ポ",
    "ｳﾞ" to "ヴ",
    "ﾜﾞ" to "ヷ",
    "ｦﾞ" to "ヺ",
)