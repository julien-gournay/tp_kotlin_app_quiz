package com.wordline.quiz.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import quiz.shared.generated.resources.Res
import quiz.shared.generated.resources.img


@Composable
fun WelcomeScreen(onStartButtonPushed: () -> Unit, viewHistoryButtonPushed: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(10.dp),
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        modifier = Modifier.size(70.dp),
                        painter = painterResource(Res.drawable.img),
                        contentDescription = null
                    )

                    Text(
                        text = "Quiz",
                        fontSize = 30.sp,
                        modifier = Modifier.padding(all = 10.dp)
                    )
                    Text(
                        modifier = Modifier.padding(all = 10.dp),
                        text = "Le quiz pour découvrir Kotlin et Android",
                    )
                    Button(
                        modifier = Modifier.padding(all = 10.dp),
                        onClick = { onStartButtonPushed() }
                    ) {
                        Text("Commencer le Quiz")
                    }
                    Button(
                        modifier = Modifier.padding(all = 10.dp),
                        onClick = { viewHistoryButtonPushed() }
                    ) {
                        Text("Voir mon historique")
                    }
                }
            }
        }
    }
}
