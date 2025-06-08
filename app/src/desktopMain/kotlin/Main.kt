import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.github.enteraname74.simplecolorthemegenerator.app.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Simple Color Theme Generator"
    ) {
        App()
    }
}