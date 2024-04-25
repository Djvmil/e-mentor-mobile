package com.djvmil.entretienmentor.ui.bottombar.shape

import com.djvmil.common.bottombar.animation.indendshape.ShapeCornerRadius
import com.djvmil.common.bottombar.animation.indendshape.shapeCornerRadius

data class IndentShapeData(
    val xIndent: Float = 0f,
    val height: Float = 0f,
    val width: Float = 0f,
    val cornerRadius: ShapeCornerRadius = shapeCornerRadius(0f),
    val ballOffset: Float = 0f,
)