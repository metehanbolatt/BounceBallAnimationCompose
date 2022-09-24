package com.metehanbolat.bounceballanimationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.metehanbolat.bounceballanimationcompose.ui.theme.BounceBallAnimationComposeTheme
import com.metehanbolat.bounceballanimationcompose.view.BallAnimation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BounceBallAnimationComposeTheme {
                BallAnimation()
            }
        }
    }
}
