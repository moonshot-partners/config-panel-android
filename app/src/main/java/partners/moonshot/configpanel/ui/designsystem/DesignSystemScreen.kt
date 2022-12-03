package partners.moonshot.configpanel.ui.designsystem

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import partners.moonshot.configpanel.ui.designsystem.flag.FeatureToggleComponent
import partners.moonshot.configpanel.ui.designsystem.joystick.MediumSpacer
import partners.moonshot.configpanel.ui.designsystem.text.Body2TextComponent
import partners.moonshot.configpanel.ui.designsystem.text.Body3TextComponent
import partners.moonshot.configpanel.ui.designsystem.text.BodyTextComponent
import partners.moonshot.configpanel.ui.designsystem.text.HeadingText2Component
import partners.moonshot.configpanel.ui.designsystem.text.HeadingText3Component
import partners.moonshot.configpanel.ui.designsystem.text.HeadingTextComponent

@Composable
fun DesignSystemScreen() {
    LazyColumn(content = {
        item {
            MediumSpacer()
            HeadingText3Component(text = "Text Component")
            MediumSpacer()
        }
        item {
            HeadingTextComponent(text = "Heading 1")
        }
        item {
            Divider()
        }
        item {
            HeadingText2Component(text = "Heading 2")
        }
        item {
            Divider()
        }
        item {
            HeadingText3Component(text = "Heading 3")
        }
        item {
            Divider()
        }
        item {
            BodyTextComponent(text = "Body")
        }
        item {
            Divider()
        }
        item {
            Body2TextComponent(text = "Body 2")
        }
        item {
            Divider()
        }
        item {
            Body3TextComponent(text = "Body 3")
        }
        item {
            MediumSpacer()
            HeadingText3Component(text = "Feature Toggle Component")
            MediumSpacer()
        }
        item {
            FeatureToggleComponent(
                modifier = Modifier,
                name = "New Feature On",
                isOnFeature = true
            ) {

            }
        }
        item {
            Divider()
        }
        item {
            FeatureToggleComponent(
                modifier = Modifier,
                name = "New Feature Off",
                isOnFeature = false
            ) {

            }
        }
    })
}
