package partners.moonshot.configpanel.ui.designsystem.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import partners.moonshot.configpanel.R
import partners.moonshot.configpanel.ui.theme.DEFAULT_TEXT_COLOR

enum class TextType {
    HEADING_1, HEADING_2, HEADING_3, BODY, BODY_2, BODY_3
}

@Composable
fun HeadingTextComponent(
    modifier: Modifier = Modifier,
    text: String,
    isShowPadding: Boolean = true,
    color: Color = DEFAULT_TEXT_COLOR,
    textAlign: TextAlign? = null
) {
    TextComponent(
        modifier,
        text,
        TextType.HEADING_1,
        isShowPadding,
        color,
        textAlign
    )
}

@Composable
fun HeadingText2Component(
    modifier: Modifier = Modifier,
    text: String,
    isShowPadding: Boolean = true,
    color: Color = DEFAULT_TEXT_COLOR,
    textAlign: TextAlign? = null
) {
    TextComponent(
        modifier,
        text,
        TextType.HEADING_2,
        isShowPadding,
        color,
        textAlign
    )
}

@Composable
fun HeadingText3Component(
    modifier: Modifier = Modifier,
    text: String,
    isShowPadding: Boolean = true,
    color: Color = DEFAULT_TEXT_COLOR,
    textAlign: TextAlign? = null
) {
    TextComponent(
        modifier,
        text,
        TextType.HEADING_3,
        isShowPadding,
        color,
        textAlign
    )
}

@Composable
fun BodyTextComponent(
    modifier: Modifier = Modifier,
    text: String,
    isShowPadding: Boolean = true,
    color: Color = DEFAULT_TEXT_COLOR,
    textAlign: TextAlign? = null
) {
    TextComponent(
        modifier,
        text,
        TextType.BODY,
        isShowPadding,
        color,
        textAlign
    )
}

@Composable
fun Body2TextComponent(
    modifier: Modifier = Modifier,
    text: String,
    isShowPadding: Boolean = true,
    color: Color = DEFAULT_TEXT_COLOR,
    textAlign: TextAlign? = null
) {
    TextComponent(
        modifier,
        text,
        TextType.BODY_2,
        isShowPadding,
        color,
        textAlign
    )
}

@Composable
fun Body3TextComponent(
    modifier: Modifier = Modifier,
    text: String,
    isShowPadding: Boolean = true,
    color: Color = DEFAULT_TEXT_COLOR,
    textAlign: TextAlign? = null
) {
    TextComponent(
        modifier,
        text,
        TextType.BODY_3,
        isShowPadding,
        color,
        textAlign
    )
}

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    text: String,
    textType: TextType,
    isShowPadding: Boolean = true,
    color: Color,
    textAlign: TextAlign? = null
) {
    val margin =
        if (isShowPadding) dimensionResource(id = R.dimen.medium_margin) else dimensionResource(id = R.dimen.no_dp)

    val headingStyle = when (textType) {
        TextType.HEADING_1 -> MaterialTheme.typography.headlineLarge
        TextType.HEADING_2 -> MaterialTheme.typography.headlineMedium
        TextType.HEADING_3 -> MaterialTheme.typography.headlineSmall
        TextType.BODY -> MaterialTheme.typography.bodyLarge
        TextType.BODY_2 -> MaterialTheme.typography.bodyMedium
        TextType.BODY_3 -> MaterialTheme.typography.bodySmall
    }
    Text(
        modifier = modifier.padding(
            horizontal = margin
        ),
        text = text,
        style = headingStyle,
        color = color,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign
    )
}