package com.wordline.quiz.data.datasources

import com.wordline.quiz.data.dataclasses.Answer
import com.wordline.quiz.data.dataclasses.Question

class MockDataSource {

    fun generateDummyQuestionsList(): List<Question> {
        return listOf(
            Question(
                1,
                "Quel langage est officiellement recommandé par Google pour le développement Android natif ?",
                1, // ID de la bonne réponse (Kotlin)
                listOf(
                    Answer(1, "Kotlin"),
                    Answer(2, "Java"),
                    Answer(3, "Dart"),
                    Answer(4, "C++")
                )
            ),
            Question(
                2,
                "Quel composant de l'architecture Android gère l'interface utilisateur graphique ?",
                2, // ID de la bonne réponse (Activity)
                listOf(
                    Answer(1, "Service"),
                    Answer(2, "Activity"),
                    Answer(3, "Broadcast Receiver"),
                    Answer(4, "Content Provider")
                )
            ),
            Question(
                3,
                "Quel outil est le SDK Manager officiel pour développer des applications Android ?",
                3, // ID de la bonne réponse (Android Studio)
                listOf(
                    Answer(1, "Xcode"),
                    Answer(2, "VS Code"),
                    Answer(3, "Android Studio"),
                    Answer(4, "Eclipse")
                )
            ),
        )
    }
}