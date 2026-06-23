package com.wordline.quiz.data.dataclasses

import kotlinx.serialization.Serializable

@Serializable
data class Answer(val id: Int, val label: String )