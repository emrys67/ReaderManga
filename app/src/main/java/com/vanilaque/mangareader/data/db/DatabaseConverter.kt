package com.vanilaque.mangareader.data.db

import androidx.room.TypeConverter

class DatabaseConverter {

    private val separator = ","

    @TypeConverter
    fun convertListToString(list: List<String>): String {
//        val stringBuilder = StringBuilder()
//        for (item in list) {
//            stringBuilder.append(item).append(separator)
//        }
//
//        stringBuilder.setLength(stringBuilder.length - separator.length)
//        return stringBuilder.toString()
        return list.joinToString(separator = separator)
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(separator)
    }
}