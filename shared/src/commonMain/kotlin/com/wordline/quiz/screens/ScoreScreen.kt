package com.wordline.quiz.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScoreScreen(
    score: Int,
    total: Int,
    isNewRecord: Boolean = false,
    onResetButtonPushed: () -> Unit,
    onViewHistoryPushed: () -> Unit,
    onBackHomePushed: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isNewRecord) Color(0xFFDAA520) else Color.Green // Golden if record
            )
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(16.dp)) {
                if (isNewRecord) {
                    Text(
                        text = "🏆 NOUVEAU RECORD ! 🏆",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                Text(
                    fontSize = 15.sp,
                    text = "score",
                )
                Text(
                    fontSize = 30.sp,
                    text = "$score/$total",
                )
                Button(
                    modifier = Modifier.padding(all = 10.dp),
                    onClick = {
                        onResetButtonPushed()
                    }
                ) {
                    Text(text = "Rejouer le quiz")
                }

                Button(
                    modifier = Modifier.padding(all = 10.dp),
                    onClick = {
                        onViewHistoryPushed()
                    }
                ) {
                    Text(text = "Voir l'historique")
                }

                Button(
                    modifier = Modifier.padding(all = 10.dp),
                    onClick = {
                        onBackHomePushed()
                    }
                ) {
                    Text(text = "Retour home")
                }
            }
        }
    }
}
