package com.djvmil.entretienmentor.core.ui.shape

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

// https://github.com/aqua30/CustomLoginDesign/
class CurvedShape(private val type: CurveType) : Shape {
  override fun createOutline(
      size: Size,
      layoutDirection: LayoutDirection,
      density: Density
  ): Outline {
    return Outline.Generic(path = if (type == CurveType.LTR) ltrCurve(size) else rtlCurve(size))
  }
}
