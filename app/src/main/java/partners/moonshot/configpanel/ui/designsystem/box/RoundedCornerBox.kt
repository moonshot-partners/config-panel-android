package partners.moonshot.configpanel.ui.designsystem.box

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import partners.moonshot.configpanel.R
import partners.moonshot.configpanel.ui.theme.BACKGROUND

@Composable
fun RoundedCornerBox(
    modifier: Modifier = Modifier,
    margin: Dp = dimensionResource(id = R.dimen.medium_margin),
    roundedCornerShape: Dp = dimensionResource(id = R.dimen.corner_shape),
    contentBackground: Color = BACKGROUND,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = margin,
                end = margin
            )
            .background(
                contentBackground, RoundedCornerShape(roundedCornerShape)
            ),
        contentAlignment = contentAlignment,
        content = content
    )
}

@Composable
fun RoundedBottomCornerBox(
    modifier: Modifier = Modifier,
    margin: Dp = dimensionResource(id = R.dimen.medium_margin),
    roundedCornerShape: Dp = dimensionResource(id = R.dimen.corner_shape),
    contentBackground: Color = BACKGROUND,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = margin,
                end = margin
            )
            .background(
                contentBackground, RoundedCornerShape(bottomEnd = roundedCornerShape, bottomStart = roundedCornerShape)
            ),
        contentAlignment = contentAlignment,
        content = content
    )
}

@Composable
fun RoundedTopCornerBox(
    modifier: Modifier = Modifier,
    margin: Dp = dimensionResource(id = R.dimen.medium_margin),
    roundedCornerShape: Dp = dimensionResource(id = R.dimen.corner_shape),
    contentBackground: Color = BACKGROUND,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = margin,
                end = margin
            )
            .background(
                contentBackground, RoundedCornerShape(topEnd = roundedCornerShape, topStart = roundedCornerShape)
            ),
        contentAlignment = contentAlignment,
        content = content
    )
}