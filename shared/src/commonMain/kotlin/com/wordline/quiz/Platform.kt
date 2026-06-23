package com.wordline.quiz

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform