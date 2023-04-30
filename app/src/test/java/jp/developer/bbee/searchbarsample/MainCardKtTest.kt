package jp.developer.bbee.searchbarsample

import org.junit.Assert
import org.junit.Test

internal class MainCardKtTest {

    @Test
    fun createSearchListTest() {
        val expectList = listOf("a", "bb", "ccc")
        var testList: List<String>
        var searchText: String

        searchText = " a bb ccc" // 先頭にスペースがある
        testList = createSearchList(searchText)
        for (i in testList.indices) {
            Assert.assertEquals(expectList[i], testList[i])
        }

        searchText = "a bb ccc " // 末尾にスペースがある
        testList = createSearchList(searchText)
        for (i in testList.indices) {
            Assert.assertEquals(expectList[i], testList[i])
        }

        searchText = "　a　bb　ccc　" // 全角スペースがある
        testList = createSearchList(searchText)
        for (i in testList.indices) {
            Assert.assertEquals(expectList[i], testList[i])
        }

        searchText = "　 a　 bb 　ccc 　" // 全角半角スペースが混在
        testList = createSearchList(searchText)
        for (i in testList.indices) {
            Assert.assertEquals(expectList[i], testList[i])
        }
    }

    @Test
    fun convertToFullWidthKatakanaTest() {
        var expect: String
        var input: String
        var converted: String

        expect = "ガ"
        input = "ｶﾞ"
        converted = convertToFullWidthKatakana(input)
        Assert.assertEquals(expect, converted)

        expect = "カ"
        input = "ｶ"
        converted = convertToFullWidthKatakana(input)
        Assert.assertEquals(expect, converted)

        expect = "カカ"
        input = "ｶｶ"
        converted = convertToFullWidthKatakana(input)
        Assert.assertEquals(expect, converted)


        expect = "ガガハパパ"
        input = "ﾞﾟガﾞﾟｶﾞﾞﾟﾊパﾞﾟﾊﾟﾞﾟ"
        converted = convertToFullWidthKatakana(input)
        Assert.assertEquals(expect, converted)
    }
}