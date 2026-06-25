package com.wordline.quiz.data

import kotlin.js.Date

actual fun getCurrentDateString(): String {
    val date = Date()
    val day = date.getDate().toInt()
    val month = (date.getMonth() + 1).toInt()
    val year = date.getFullYear().toInt()
    val hour = date.getHours().toInt()
    val minute = date.getMinutes().toInt()
    return "$day/$month/$year $hour:${minute.toString().padStart(2, '0')}"
}
