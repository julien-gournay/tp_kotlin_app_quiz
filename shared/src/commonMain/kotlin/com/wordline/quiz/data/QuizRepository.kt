package com.wordline.quiz.data

import com.wordline.quiz.data.dataclasses.HistoryEntry
import com.wordline.quiz.data.dataclasses.Question
import com.wordline.quiz.data.datasources.QuizApiDatasource
import com.wordline.quiz.data.datasources.MockDataSource

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
        // Vérifiez si le score actuel dépasse le score élevé précédent
        val isNewRecord = score > _highScore
        if (isNewRecord) {
            _highScore = score
        }
        val dateStr = getCurrentDateString()
        _history.add(HistoryEntry(score, total, dateStr))
        return isNewRecord
    }

    fun getHistory(): List<HistoryEntry> = _history.toList()

    fun clearHistory() {
        _history.clear()
    }

    fun getHighScore(): Int = _highScore
}