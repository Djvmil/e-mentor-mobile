package com.djvmil.entretienmentor.feature.ui

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier,
    circleSize: Dp = 25.dp,
    circleColor: Color = MaterialTheme.colorScheme.primary,
    spaceBetween: Dp = 10.dp,
    travelDistance: Dp = 20.dp,
    isLoading: Boolean
) {
  val circles =
      listOf(
          remember { Animatable(initialValue = 0f) },
          remember { Animatable(initialValue = 0f) },
          remember { Animatable(initialValue = 0f) })

  circles.forEachIndexed { index, animatable ->
    LaunchedEffect(key1 = animatable) {
      delay(index * 100L)
      animatable.animateTo(
          targetValue = 1f,
          animationSpec =
              infiniteRepeatable(
                  animation =
                      keyframes {
                        durationMillis = 1200
                        0.0f at 0 using LinearOutSlowInEasing
                        1.0f at 300 using LinearOutSlowInEasing
                        0.0f at 600 using LinearOutSlowInEasing
                        0.0f at 1200 using LinearOutSlowInEasing
                      },
                  repeatMode = RepeatMode.Restart))
    }
  }

  val circleValues = circles.map { it.value }
  val distance = with(LocalDensity.current) { travelDistance.toPx() }

  if (isLoading) {

    Scaffold(modifier = modifier) {
      Box(
          modifier = Modifier.fillMaxSize(),
          contentAlignment = Alignment.Center,
      ) {
        Row(horizontalArrangement = Arrangement.spacedBy(spaceBetween)) {
          circleValues.forEach { value ->
            Box(
                modifier =
                    Modifier.size(circleSize)
                        .graphicsLayer { translationY = -value * distance }
                        .background(color = circleColor, shape = CircleShape))
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun LoadingAnimationPreview() {
  LoadingAnimation(isLoading = true)
}
