package com.wordline.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wordline.quiz.data.dataclasses.HistoryEntry
import com.wordline.quiz.data.dataclasses.Question
import com.wordline.quiz.data.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class QuizViewModel : ViewModel() {
    private var quizRepository: QuizRepository = QuizRepository()
    private var _questionState = MutableStateFlow(listOf<Question>())
    var questionState: StateFlow<List<Question>> = _questionState

    private var _historyState = MutableStateFlow(listOf<HistoryEntry>())
    var historyState: StateFlow<List<HistoryEntry>> = _historyState

    init {
        getQuestionQuiz()
        updateHistory()
    }

    fun updateHistory() {
        _historyState.update { quizRepository.getHistory() }
    }

    fun addHistory(score: Int, total: Int): Boolean {
        val isNewRecord = quizRepository.addHistoryEntry(score, total)
        updateHistory()
        return isNewRecord
    }

    fun resetHistory() {
        quizRepository.clearHistory()
        updateHistory()
    }

    private fun getQuestionQuiz() {

        viewModelScope.launch(Dispatchers.Default) {
            _questionState.update {
                quizRepository.updateQuiz()
            }
        }
    }

}