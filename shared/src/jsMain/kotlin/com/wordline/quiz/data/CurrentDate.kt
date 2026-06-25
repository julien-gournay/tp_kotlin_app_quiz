package com.wordline.quiz.data

actual fun getCurrentDateString(): String {
    val date = js("new Date()").unsafeCast<kotlin.js.JsAny>()
    val day = js("date.getDate()").unsafeCast<Int>()
    val month = js("date.getMonth() + 1").unsafeCast<Int>()
    val year = js("date.getFullYear()").unsafeCast<Int>()
    val hour = js("date.getHours()").unsafeCast<Int>()
    val minute = js("date.getMinutes()").unsafeCast<Int>()
    return "$day/$month/$year $hour:${minute.toString().padStart(2, '0')}"
}
