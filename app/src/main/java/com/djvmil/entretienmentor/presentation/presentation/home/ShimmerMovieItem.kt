package com.djvmil.entretienmentor.presentation.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.djvmil.entretienmentor.presentation.util.ShimmerRectangleHeight
import com.djvmil.entretienmentor.ui.theme.SmallPadding
import com.djvmil.entretienmentor.ui.widget.shimmer.ShimmerRectangle

@Composable
fun ShimmerMovieItem(
    isEnableShimmer: Boolean
) {
    Column(
        modifier = Modifier
           // .width(MovieItemWidth)
            //.clip(RoundedCornerShape(size = MovieItemRound))
    ) {
        /*ShimmerRectangle(
            isEnableShimmer = isEnableShimmer,
            width = MovieItemWidth,
            height = MovieItemHeight,
            round = MovieItemRound,
            padding = SmallPadding
        )

        ShimmerRectangle(
            isEnableShimmer = isEnableShimmer,
            width = MovieItemWidth,
            height = ShimmerRectangleHeight,
            round = MovieItemRound,
            padding = SmallPadding
        )*/
    }
}

@Preview
@Composable
private fun ShimmerMovieItemPreview() = ShimmerMovieItem(true)