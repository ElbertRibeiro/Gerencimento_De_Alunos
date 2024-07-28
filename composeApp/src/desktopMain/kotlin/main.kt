import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import navigation.setupNavigation

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        resizable = false,
        state = rememberWindowState(size = DpSize(width = 1280.dp, height = 720.dp)),
        title = "School Management",
        icon = painterResource("icon.jpeg")
    ) {
        setupNavigation()
    }
}