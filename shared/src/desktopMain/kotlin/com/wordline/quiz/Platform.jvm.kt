package com.wordline.quiz

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()



@Composable
@Preview
fun AppDesktopPreview(){
    App()
}