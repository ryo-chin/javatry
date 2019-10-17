package org.docksidestage.javatry.colorbox

import org.docksidestage.bizfw.colorbox.yours.YourPrivateRoom
import org.docksidestage.unit.PlainTestCase

class KotlinStep12StreamStringTest : PlainTestCase() {
    // ===================================================================================
    //                                                                            length()
    //                                                                            ========
    /**
     * What is color name length of first color-box? <br></br>
     * (最初のカラーボックスの色の名前の文字数は？)
     */
    fun test_length_basic() {
        val colorBoxList = YourPrivateRoom().colorBoxList
        val answer = colorBoxList.stream()
                .findFirst()
                .map { colorBox -> colorBox.color.colorName }
                .map { colorName -> colorName.length.toString() + " (" + colorName + ")" }
                .orElse("*not found")
        log(answer)
    }

    /**
     * Which string has max length in color-boxes? <br></br>
     * (カラーボックスに入ってる文字列の中で、一番長い文字列は？)
     */
    fun test_length_findMax() {
        val colorBoxList = YourPrivateRoom().colorBoxList
        val maxStr = colorBoxList
                .flatMap { it.spaceList }
                .mapNotNull { it.content }
                .filterIsInstance<String>()
                .minBy { it.length }
        log(maxStr)
    }

    /**
     * How many characters are difference between max and min length of string in color-boxes? <br></br>
     * (カラーボックスに入ってる文字列の中で、一番長いものと短いものの差は何文字？)
     */
    fun test_length_findMaxMinDiff() {
        val colorBoxList = YourPrivateRoom().colorBoxList
        val strContents = colorBoxList
                .flatMap { it.spaceList }
                .mapNotNull { it.content }
                .filterIsInstance<String>()
        val maxStr = strContents.maxBy { it.length } ?: ""
        val minStr = strContents.minBy { it.length } ?: ""
        if (maxStr.length == minStr.length) {
            log("一番長いものと短いものなんて存在しないのである")
            return
        }
        log(maxStr.length - minStr.length)
    }

    // has small #adjustmemts from ClassicStringTest
    //  o sort allowed in Stream
    /**
     * Which value (toString() if non-string) has second-max length in color-boxes? (sort allowed in Stream)<br></br>
     * (カラーボックスに入ってる値 (文字列以外はtoString()) の中で、二番目に長い文字列は？ (Streamでのソートありで))
     */
    fun test_length_findSecondMax() {
        val colorBoxList = YourPrivateRoom().colorBoxList
        val sortedContents = colorBoxList
                .flatMap { it.spaceList }
                .mapNotNull { it.content }
                .map { it.toString() }
                .sortedByDescending { it.length }
        log(sortedContents[1])
    }

    /**
     * How many total lengths of strings in color-boxes? <br></br>
     * (カラーボックスに入ってる文字列の長さの合計は？)
     */
    fun test_length_calculateLengthSum() {
        val colorBoxList = YourPrivateRoom().colorBoxList
        val totalLength = colorBoxList
                .flatMap { it.spaceList }
                .mapNotNull { it.content }
                .filterIsInstance<String>()
                .sumBy { it.length }
        log(totalLength)
    }

    /**
     * Which color name has max length in color-boxes? <br></br>
     * (カラーボックスの中で、色の名前が一番長いものは？)
     */
    fun test_length_findMaxColorSize() {}

// ===================================================================================
//                                                            startsWith(), endsWith()
//                                                            ========================
    /**
     * What is color in the color-box that has string starting with "Water"? <br></br>
     * ("Water" で始まる文字列をしまっているカラーボックスの色は？)
     */
    fun test_startsWith_findFirstWord() {}

    /**
     * What is color in the color-box that has string ending with "front"? <br></br>
     * ("front" で終わる文字列をしまっているカラーボックスの色は？)
     */
    fun test_endsWith_findLastWord() {}

// ===================================================================================
//                                                            indexOf(), lastIndexOf()
//                                                            ========================
    /**
     * What number character is starting with first "front" of string ending with "front" in color-boxes? <br></br>
     * (カラーボックスに入ってる "front" で終わる文字列で、最初の "front" は何文字目から始まる？)
     */
    fun test_indexOf_findIndex() {}

    /**
     * What number character is starting with the late "ど" of string containing plural "ど"s in color-boxes? (e.g. "どんどん" => 3) <br></br>
     * (カラーボックスに入ってる「ど」を二つ以上含む文字列で、最後の「ど」は何文字目から始まる？ (e.g. "どんどん" => 3))
     */
    fun test_lastIndexOf_findIndex() {}

// ===================================================================================
//                                                                         substring()
//                                                                         ===========
    /**
     * What character is first of string ending with "front" in color-boxes? <br></br>
     * (カラーボックスに入ってる "front" で終わる文字列の最初の一文字は？)
     */
    fun test_substring_findFirstChar() {}

    /**
     * What character is last of string starting with "Water" in color-boxes? <br></br>
     * (カラーボックスに入ってる "Water" で始まる文字列の最後の一文字は？)
     */
    fun test_substring_findLastChar() {}

// ===================================================================================
//                                                                           replace()
//                                                                           =========
    /**
     * How many characters does string that contains "o" in color-boxes and removing "o" have? <br></br>
     * (カラーボックスに入ってる "o" (おー) を含んだ文字列から "o" を全て除去したら何文字？)
     */
    fun test_replace_remove_o() {}

    /**
     * What string is path string of java.io.File in color-boxes, which is replaced with "/" to Windows file separator? <br></br>
     * カラーボックスに入ってる java.io.File のパス文字列のファイルセパレーターの "/" を、Windowsのファイルセパレーターに置き換えた文字列は？
     */
    fun test_replace_fileseparator() {}

// ===================================================================================
//                                                                    Welcome to Devil
//                                                                    ================
    /**
     * What is total length of text of DevilBox class in color-boxes? <br></br>
     * (カラーボックスの中に入っているDevilBoxクラスのtextの長さの合計は？)
     */
    fun test_welcomeToDevil() {}

// ===================================================================================
//                                                                           Challenge
//                                                                           =========
    /**
     * What string is converted to style "map:{ key = value ; key = value ; ... }" from java.util.Map in color-boxes? <br></br>
     * (カラーボックスの中に入っている java.util.Map を "map:{ key = value ; key = value ; ... }" という形式で表示すると？)
     */
    fun test_showMap_flat() {}

    /**
     * What string is converted to style "map:{ key = value ; key = map:{ key = value ; ... } ; ... }" from java.util.Map in color-boxes? <br></br>
     * (カラーボックスの中に入っている java.util.Map を "map:{ key = value ; key = map:{ key = value ; ... } ; ... }" という形式で表示すると？)
     */
    fun test_showMap_nested() {}

// ===================================================================================
//                                                                           Good Luck
//                                                                           =========
// has small #adjustmemts from ClassicStringTest
//  o comment out because of too difficult to be stream?
///**
// * What string of toString() is converted from text of SecretBox class in upper space on the "white" color-box to java.util.Map? <br>
// * (whiteのカラーボックスのupperスペースに入っているSecretBoxクラスのtextをMapに変換してtoString()すると？)
// */
//public void test_parseMap_flat() {
//}
//
///**
// * What string of toString() is converted from text of SecretBox class in both middle and lower spaces on the "white" color-box to java.util.Map? <br>
// * (whiteのカラーボックスのmiddleおよびlowerスペースに入っているSecretBoxクラスのtextをMapに変換してtoString()すると？)
// */
//public void test_parseMap_nested() {
//}
}