import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

dependencies {
    implementation(projects.shared)

    implementation(compose.desktop.currentOs)
    implementation(libs.kotlinx.coroutinesSwing)
    implementation(libs.kotlinx.datetime)

    implementation(libs.compose.uiToolingPreview)

    implementation(compose.materialIconsExtended)
}

compose.desktop {
    application {
        mainClass = "com.wordline.quiz.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.wordline.quiz"
            packageVersion = "1.0.0"
        }
    }
}