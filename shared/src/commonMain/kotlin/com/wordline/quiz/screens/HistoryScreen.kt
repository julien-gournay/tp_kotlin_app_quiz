package com.wordline.quiz.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import com.wordline.quiz.data.dataclasses.HistoryEntry


@Composable
fun HistoryScreen(
    history: List<HistoryEntry>,
    onBackToWelcomePushed: () -> Unit,
    onResetHistoryPushed: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(10.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Historique",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                LazyColumn(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(history) { entry ->
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Score: ${entry.score}/${entry.total}", fontSize = 18.sp)
                            Text(text = entry.dateTime, fontSize = 14.sp, color = androidx.compose.ui.graphics.Color.Gray)
                            HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
                        }
                    }
                }

                Button(
                    modifier = Modifier.padding(top = 16.dp),
                    onClick = { onResetHistoryPushed() }
                ) {
                    Text("Réinitialiser l'historique")
                }

                Button(
                    modifier = Modifier.padding(top = 8.dp),
                    onClick = { onBackToWelcomePushed() }
                ) {
                    Text("Home")
                }
            }
        }
    }
}
