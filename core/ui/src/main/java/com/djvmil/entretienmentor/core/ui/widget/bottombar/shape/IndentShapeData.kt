package com.djvmil.entretienmentor.core.ui.widget.bottombar.shape

import com.djvmil.entretienmentor.core.ui.widget.bottombar.animation.indendshape.ShapeCornerRadius
import com.djvmil.entretienmentor.core.ui.widget.bottombar.animation.indendshape.shapeCornerRadius

data class IndentShapeData(
    val xIndent: Float = 0f,
    val height: Float = 0f,
    val width: Float = 0f,
    val cornerRadius: ShapeCornerRadius = shapeCornerRadius(0f),
    val ballOffset: Float = 0f,
)
