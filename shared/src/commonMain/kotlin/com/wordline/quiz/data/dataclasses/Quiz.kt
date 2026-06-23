package com.wordline.quiz.data.dataclasses

import kotlinx.serialization.Serializable

@Serializable
data class Quiz(var questions: List<Question>)
