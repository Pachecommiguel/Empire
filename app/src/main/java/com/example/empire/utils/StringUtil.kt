package com.example.empire.utils

object StringUtil {

    fun getFormattedLanguage(src: String): String = when(src.indexOf(' ') < 0) {
        true -> src.substring(0, src.length - 2) + " " + src.last()
        false -> src
    }
}