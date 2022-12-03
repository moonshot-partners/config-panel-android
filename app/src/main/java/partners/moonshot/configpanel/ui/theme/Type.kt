package partners.moonshot.configpanel.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import partners.moonshot.configpanel.R


private val noentiendoFont = FontFamily(fonts = listOf(Font(R.font.noentiendo)))
val DEFAULT_TEXT_COLOR = Color(0xFF091524)

// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = noentiendoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = noentiendoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = noentiendoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    headlineSmall = TextStyle(
        color = DEFAULT_TEXT_COLOR,
        fontSize = 22.sp,
        fontFamily = noentiendoFont
    ),
    headlineMedium = TextStyle(
        color = DEFAULT_TEXT_COLOR,
        fontSize = 32.sp,
        fontFamily = noentiendoFont
    ),
    headlineLarge = TextStyle(
        color = DEFAULT_TEXT_COLOR,
        fontSize = 40.sp,
        fontFamily = noentiendoFont
    )
)