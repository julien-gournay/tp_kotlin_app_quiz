package com.wordline.quiz.data

import com.wordline.quiz.data.dataclasses.HistoryEntry
import com.wordline.quiz.data.dataclasses.Question
import com.wordline.quiz.data.datasources.QuizApiDatasource
import com.worldline.quiz.data.datasources.MockDataSource
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class QuizRepository()  {

    private val mockDataSource = MockDataSource()
    private val quizApiDatasource = QuizApiDatasource()
    private val _history = mutableListOf<HistoryEntry>()
    private var _highScore = 0

    private suspend fun fetchQuiz(): List<Question> = quizApiDatasource.getAllQuestions().questions

    suspend fun updateQuiz(): List<Question> {
        try {
            val result = fetchQuiz()
            println("QuizRepository: Successfully fetched ${result.size} questions from API")
            return result
        } catch (e: Exception) {
            println("QuizRepository: Error fetching from API: ${e.message}")
            e.printStackTrace()
            val dummyQuestions = mockDataSource.generateDummyQuestionsList()
            println("QuizRepository: Falling back to ${dummyQuestions.size} dummy questions")
            return dummyQuestions
        }
    }

    fun addHistoryEntry(score: Int, total: Int): Boolean {
        val isNewRecord = score > _highScore
        if (isNewRecord) {
            _highScore = score
        }
        val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val dateStr = "${now.dayOfMonth}/${now.monthNumber}/${now.year} ${now.hour}:${now.minute.toString().padStart(2, '0')}"
        _history.add(HistoryEntry(score, total, dateStr))
        return isNewRecord
    }

    fun getHistory(): List<HistoryEntry> = _history.toList()

    fun clearHistory() {
        _history.clear()
    }

    fun getHighScore(): Int = _highScore
}