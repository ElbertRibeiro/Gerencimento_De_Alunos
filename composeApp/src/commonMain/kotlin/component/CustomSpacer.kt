package component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object CustomSpacer {
    @Composable
    fun space8pd() {
        Spacer(modifier = Modifier.height(8.dp))
    }
}