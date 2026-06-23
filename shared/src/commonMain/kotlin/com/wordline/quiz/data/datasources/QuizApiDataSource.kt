package com.wordline.quiz.data.datasources

import com.wordline.quiz.data.dataclasses.Quiz
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

val globalHttpClient = HttpClient {
    engine {

    }
    /*install(HttpCache) {
        privateStorage(
            storage = CacheStorage.Unlimited.invoke()
        )
    }*/

    install(ContentNegotiation) {
        json(
            contentType = ContentType.Any,
            json = Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
                isLenient = true
            })
    }
}

class QuizApiDatasource {
    private val httpClient = globalHttpClient
    suspend fun getAllQuestions(): Quiz {
        return httpClient.get("https://juliengournay.fr/files/quiz.json").body()
    }
}
