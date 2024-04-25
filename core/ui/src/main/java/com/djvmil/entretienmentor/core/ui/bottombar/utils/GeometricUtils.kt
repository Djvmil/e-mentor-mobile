package com.djvmil.entretienmentor.ui.bottombar.utils

fun lerp(start: Float, stop: Float, fraction: Float) =
    (start * (1 - fraction) + stop * fraction)