package partners.moonshot.configpanel.ui.designsystem.layouts

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

interface Decoration {
    fun drawDecoration(contentDrawScope: ContentDrawScope)
}

val DEFAULT_STROKE_WIDTH = 6.dp
sealed class Frames : Decoration {
    class UpButtonCorners(
        private val color: Color = Color.White, private val strokeWidth: Dp = DEFAULT_STROKE_WIDTH
    ) : Frames() {
        override fun drawDecoration(contentDrawScope: ContentDrawScope) {
            contentDrawScope.drawLine(
                color = color,
                start = Offset(0f, 0f),
                end = Offset(contentDrawScope.size.height, 0f),
                strokeWidth = strokeWidth.value
            )
            contentDrawScope.drawLine(
                color = color,
                start = Offset(0f, 0f),
                end = Offset(0f, contentDrawScope.size.height),
                strokeWidth = strokeWidth.value
            )
            contentDrawScope.drawLine(
                color = Color.White,
                start = Offset(contentDrawScope.size.width, 0f),
                end = Offset(contentDrawScope.size.width, contentDrawScope.size.height),
                strokeWidth = strokeWidth.value
            )
        }
    }

    class LeftButtonCorners(
        private val color: Color = Color.White, private val strokeWidth: Dp = DEFAULT_STROKE_WIDTH
    ) : Frames() {
        override fun drawDecoration(contentDrawScope: ContentDrawScope) {
            // UP
            contentDrawScope.drawLine(
                color = color,
                start = Offset(0f, 0f),
                end = Offset(contentDrawScope.size.width, 0f),
                strokeWidth = strokeWidth.value
            )
            //Left
            contentDrawScope.drawLine(
                color = color,
                start = Offset(0f, 0f),
                end = Offset(0f, contentDrawScope.size.height),
                strokeWidth = strokeWidth.value
            )

            contentDrawScope.drawLine(
                color = color,
                start = Offset(0f, contentDrawScope.size.height),
                end = Offset(contentDrawScope.size.width, contentDrawScope.size.height),
                strokeWidth = strokeWidth.value
            )
        }
    }

    class RightButtonCorners(
        private val color: Color = Color.White,
        private val strokeWidth: Dp = DEFAULT_STROKE_WIDTH
    ) : Frames() {
        override fun drawDecoration(contentDrawScope: ContentDrawScope) {
            contentDrawScope.drawLine(
                color = color,
                start = Offset(0f, 0f),
                end = Offset(contentDrawScope.size.width, 0f),
                strokeWidth = strokeWidth.value
            )
            contentDrawScope.drawLine(
                color = color,
                start = Offset(contentDrawScope.size.width, 0f),
                end = Offset(contentDrawScope.size.width, contentDrawScope.size.height),
                strokeWidth = strokeWidth.value
            )
            contentDrawScope.drawLine(
                color = color,
                start = Offset(
                    0f, contentDrawScope.size.height
                ),
                end = Offset(contentDrawScope.size.width, contentDrawScope.size.height),
                strokeWidth = strokeWidth.value
            )
        }
    }

    class BottomButtonCorners(
        private val color: Color = Color.White,
        private val strokeWidth: Dp = DEFAULT_STROKE_WIDTH
    ) : Frames() {
        override fun drawDecoration(contentDrawScope: ContentDrawScope) {
            contentDrawScope.drawLine(
                color = color,
                start = Offset(0f, 0f),
                end = Offset(0f, contentDrawScope.size.height),
                strokeWidth = strokeWidth.value
            )
            contentDrawScope.drawLine(
                color = color,
                start = Offset(0f, contentDrawScope.size.height),
                end = Offset(contentDrawScope.size.width, contentDrawScope.size.height),
                strokeWidth = strokeWidth.value
            )
            contentDrawScope.drawLine(
                color = color,
                start = Offset(
                    contentDrawScope.size.width, 0f
                ),
                end = Offset(contentDrawScope.size.width, contentDrawScope.size.height),
                strokeWidth = strokeWidth.value
            )
        }
    }
}