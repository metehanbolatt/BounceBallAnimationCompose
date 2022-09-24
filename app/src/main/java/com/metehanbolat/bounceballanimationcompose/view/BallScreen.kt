package com.metehanbolat.bounceballanimationcompose.view

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.metehanbolat.bounceballanimationcompose.R
import com.metehanbolat.bounceballanimationcompose.ui.theme.BlackColor

enum class BallPosition {
    START, FINISH
}

@Composable
fun BallAnimation() {
    var ballState by remember { mutableStateOf(BallPosition.START) }
    val infiniteTransition = rememberInfiniteTransition()
    val dy by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val travelDistance = with(LocalDensity.current) { 280.dp.toPx() }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.padding(50.dp),
            onClick = {
                ballState = when(ballState) {
                    BallPosition.START -> BallPosition.FINISH
                    BallPosition.FINISH -> BallPosition.START
                }
            }
        ) {
            Text(text = "Jump")
        }
        Image(
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
                .zIndex(2f)
                .graphicsLayer {
                    if (ballState == BallPosition.FINISH) {
                        translationY = dy * travelDistance
                    }
                },
            painter = painterResource(id = R.drawable.ball),
            contentDescription = null
        )

    }

    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(1f),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.drawable.floor),
            contentDescription = null
        )
    }

}

@Preview
@Composable
fun PreviewBallAnimation() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BlackColor
    ) {
        BallAnimation()
    }
}