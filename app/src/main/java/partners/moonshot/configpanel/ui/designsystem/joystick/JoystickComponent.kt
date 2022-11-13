package partners.moonshot.configpanel.ui.designsystem.joystick

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import partners.moonshot.configpanel.R
import partners.moonshot.configpanel.ui.designsystem.box.RoundedBottomCornerBox
import partners.moonshot.configpanel.ui.designsystem.box.RoundedCornerBox
import partners.moonshot.configpanel.ui.designsystem.box.RoundedTopCornerBox
import partners.moonshot.configpanel.ui.designsystem.layouts.Frames
import partners.moonshot.configpanel.ui.designsystem.layouts.addDecoration
import partners.moonshot.configpanel.ui.theme.BACKGROUND
import partners.moonshot.configpanel.ui.theme.JOYSTICK_BACKGROUND
import partners.moonshot.configpanel.ui.theme.JOYSTICK_GRAY
import partners.moonshot.configpanel.ui.theme.JOYSTICK_LIGTH_GRAY
import partners.moonshot.configpanel.ui.theme.JOYSTICK_RED

@Composable
fun JoystickComponent(
    modifier: Modifier = Modifier, onKeyEvent: (JoystickKeyEvent) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(
                all = dimensionResource(id = R.dimen.medium_margin)
            )
            .background(color = BACKGROUND)
    ) {

        RoundedCornerBox(
            modifier = Modifier.fillMaxSize(), contentBackground = JOYSTICK_BACKGROUND
        ) {
            RoundedCornerBox(
                modifier
                    .fillMaxSize()
                    .padding(
                        top = 48.dp, bottom = 16.dp, start = 16.dp, end = 16.dp
                    ), contentBackground = Color.Black
            ) {
                Row(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row {
                            DirectionalButtons(modifier = Modifier.size(120.dp))
                            LargeSpacer()
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    ) {
                        RoundedBottomCornerBox(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(dimensionResource(id = R.dimen.joystick_gray_height)),
                            contentBackground = JOYSTICK_GRAY
                        ) {}
                        SmallSpacer()
                        RoundedCornerBox(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(dimensionResource(id = R.dimen.joystick_gray_height)),
                            contentBackground = JOYSTICK_GRAY
                        ) {}
                        SmallSpacer()
                        RoundedCornerBox(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(dimensionResource(id = R.dimen.joystick_gray_height)),
                            contentBackground = JOYSTICK_GRAY
                        ) {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    modifier = Modifier.weight(1f),
                                    text = stringResource(id = R.string.select),
                                    color = JOYSTICK_RED,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    modifier = Modifier.weight(1f),
                                    text = stringResource(id = R.string.start),
                                    color = JOYSTICK_RED,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        SmallSpacer()
                        RoundedCornerBox(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(dimensionResource(id = R.dimen.joystick_white_height)),
                            contentBackground = JOYSTICK_LIGTH_GRAY
                        ) {
                            RoundedCornerBox(
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp, start = 6.dp, end = 6.dp)
                                    .border(
                                        1.dp, color = Color.Black, shape = RoundedCornerShape(
                                            dimensionResource(id = R.dimen.corner_shape)
                                        )
                                    )
                                    .fillMaxSize(),
                                contentBackground = JOYSTICK_LIGTH_GRAY,
                                margin = dimensionResource(id = R.dimen.smallest_margin)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RoundedCornerBox(
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(26.dp),
                                        roundedCornerShape = dimensionResource(id = R.dimen.corner_shape_large),
                                        contentBackground = Color.Black,
                                        margin = dimensionResource(id = R.dimen.smallest_margin)
                                    ) {}
                                    MediumSpacer()
                                    RoundedCornerBox(
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(26.dp),
                                        roundedCornerShape = dimensionResource(id = R.dimen.corner_shape_large),
                                        contentBackground = Color.Black,
                                        margin = dimensionResource(id = R.dimen.smallest_margin)
                                    ) {}
                                }
                            }
                        }
                        SmallSpacer()
                        RoundedTopCornerBox(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentBackground = JOYSTICK_GRAY
                        ) {}
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ExtraLargeSpacer()
                        Text(text = stringResource(id = R.string.no_entiendo), color = JOYSTICK_RED)
                        ExtraLargeSpacer()
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.BottomStart
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                LargeSpacer()
                                CircleJoystickButton(value = stringResource(id = R.string.b)) {
                                    onKeyEvent(JoystickKeyEvent.B)
                                }
                                SmallSpacer()
                                CircleJoystickButton(
                                    color = JOYSTICK_RED,
                                    value = stringResource(id = R.string.a)
                                ) {
                                    onKeyEvent(JoystickKeyEvent.A)
                                }
                                ExtraLargeSpacer()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CircleJoystickButton(
    modifier: Modifier = Modifier,
    color: Color = JOYSTICK_RED,
    value: String,
    onClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.End) {
        RoundedCornerBox(
            modifier = Modifier.size(dimensionResource(id = R.dimen.joystick_button_size)),
            contentBackground = Color.White,
            margin = dimensionResource(id = R.dimen.no_dp)
        ) {
            Box(
                modifier = modifier
                    .padding(6.dp)
                    .fillMaxSize()
                    .background(color = color, shape = CircleShape)
                    .clip(shape = CircleShape)
                    .clickable(onClick = onClick)
            )
        }
        Text(text = value, color = JOYSTICK_RED)
    }

}

@Composable
fun ExtraLargeSpacer() {
    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.extra_large_margin)))
}

@Composable
fun LargeSpacer() {
    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.large_margin)))
}

@Composable
fun MediumSpacer() {
    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.medium_margin)))
}

@Composable
fun SmallSpacer() {
    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.small_margin)))
}

@Composable
fun SmallestSpacer() {
    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.smallest_margin)))
}

@Composable
fun ColorBox(modifier: Modifier) {
    Box(
        Modifier
            .padding(1.dp)
            .size(width = 50.dp, height = 10.dp)
            .then(modifier)
    )
}

@Composable
fun DirectionalButtons(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(modifier = modifier) {
            val borderColor = Color.White
            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.weight(1f))
                RoundedTopCornerBox(
                    modifier = Modifier
                        .weight(1f)
                        .addDecoration(Frames.UpButtonCorners(color = borderColor))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                RoundedTopCornerBox(
                    modifier = Modifier
                        .weight(1f)
                        .addDecoration(Frames.LeftButtonCorners(color = borderColor)),
                    contentBackground = Color.White
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null
                    )
                }
                RoundedTopCornerBox(
                    modifier = Modifier.weight(1f),
                    contentBackground = Color.White
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null
                    )
                }
                RoundedTopCornerBox(
                    modifier = Modifier
                        .weight(1f)
                        .addDecoration(Frames.RightButtonCorners(color = borderColor)),
                    contentBackground = Color.White
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null
                    )
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.weight(1f))
                RoundedBottomCornerBox(
                    modifier = Modifier
                        .weight(1f)
                        .addDecoration(Frames.BottomButtonCorners(color = borderColor)),
                    contentBackground = Color.White
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

enum class JoystickKeyEvent {
    UP, DOWN, LEFT, RIGTH, A, B, START, SELECT
}