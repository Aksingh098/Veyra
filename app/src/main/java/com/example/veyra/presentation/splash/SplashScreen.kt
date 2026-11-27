package com.example.veyra.presentation.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.veyra.R
import kotlinx.coroutines.delay

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    var startAnimation by remember { mutableStateOf(false) }

    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(4000)

    )

    LaunchedEffect(true) {
        startAnimation  = true
        delay(2500)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1C1917),
                        Color(0xFF121110),
                        Color(0xFF090909)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.elegant_gold_veyra_logo),
            contentDescription = "App logo",
            modifier = Modifier
                .width(240.dp)
                .alpha(alphaAnim.value),
            contentScale = ContentScale.Fit
        )
    }

}


@Composable
fun OnBoardContent() {



}