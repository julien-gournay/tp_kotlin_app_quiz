package com.wordline.quiz.data

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

actual fun getCurrentDateString(): String {
    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    return "${now.dayOfMonth}/${now.monthNumber}/${now.year} ${now.hour}:${now.minute.toString().padStart(2, '0')}"
}
