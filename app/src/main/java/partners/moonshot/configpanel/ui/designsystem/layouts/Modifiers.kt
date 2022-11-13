package partners.moonshot.configpanel.ui.designsystem.layouts

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.layout.layout
import kotlin.math.roundToInt

fun Modifier.exampleLayout(
    horizontalPosition: Int,
    verticalPosition: Int
): Modifier {
    return layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.width, placeable.height) {
            placeable.placeRelative(horizontalPosition, verticalPosition)
        }
    }
}

fun Modifier.exampleLayout(
    fraction: Float
): Modifier {
    return layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val x = -(placeable.width * fraction).roundToInt()
        layout(placeable.width, placeable.height) {
            placeable.placeRelative(x, 0)
        }
    }
}

fun Modifier.addDecoration(decoration: Decoration) = then(
    object : DrawModifier {
        override fun ContentDrawScope.draw() {
            drawContent()
            decoration.drawDecoration(this)
        }
    }
)