package com.wordline.quiz.data.dataclasses

import kotlinx.serialization.Serializable

@Serializable
data class HistoryEntry(
    val score: Int,
    val total: Int,
    val dateTime: String
)
