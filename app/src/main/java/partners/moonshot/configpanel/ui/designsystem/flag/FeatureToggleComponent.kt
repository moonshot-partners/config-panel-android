package partners.moonshot.configpanel.ui.designsystem.flag

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import partners.moonshot.configpanel.R
import partners.moonshot.configpanel.ui.designsystem.joystick.MediumSpacer
import partners.moonshot.configpanel.ui.designsystem.joystick.SmallestSpacer
import partners.moonshot.configpanel.ui.designsystem.text.BodyTextComponent
import partners.moonshot.configpanel.ui.theme.DEFAULT_TEXT_COLOR


@Composable
fun FeatureToggleComponent(
    modifier: Modifier = Modifier,
    name: String,
    isOnFeature: Boolean,
    onClickComponent: (Boolean) -> Unit
) {
    val iconToggle = if (isOnFeature) R.drawable.ic_toggle_on else R.drawable.ic_toggle_off
    val backgroundTextColor = if (isOnFeature) Color(0xFF007205) else Color(0xFFE51D61)
    Row(modifier = modifier.clickable(onClick = { onClickComponent(isOnFeature.not()) })) {
        BodyTextComponent(modifier = modifier.weight(7f), text = name, color = backgroundTextColor)
        Icon(
            modifier = modifier.weight(3f),
            painter = painterResource(id = iconToggle),
            contentDescription = null
        )
    }
}
