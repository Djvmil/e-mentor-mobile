package com.djvmil.entretienmentor.feature.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import com.djvmil.entretienmentor.core.common.model.ResultEM
import com.djvmil.entretienmentor.core.ui.designsystem.theme.DetailCardHeight
import com.djvmil.entretienmentor.core.ui.designsystem.theme.DetailIcon
import com.djvmil.entretienmentor.core.ui.designsystem.theme.DetailImageAspectRatio
import com.djvmil.entretienmentor.core.ui.designsystem.theme.MovieDetailItemTextStyle
import com.djvmil.entretienmentor.core.ui.designsystem.theme.MovieDetailTextStyle
import com.djvmil.entretienmentor.core.ui.designsystem.theme.NormalPadding
import com.djvmil.entretienmentor.core.ui.designsystem.theme.SmallPadding
import com.djvmil.entretienmentor.feature.ui.community.model.CommunityUiModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = koinViewModel(),
    communityId: Int,
    onBackClicked: () -> Unit
) {
  val uiState by viewModel.uiState.collectAsState()

  LaunchedEffect(
      key1 = true,
  ) {
    viewModel.getCommunity(communityId)
  }

  Button(onClick = { onBackClicked.invoke() }) { Text(text = "Back") }
  when (uiState) {
    ResultEM.Loading -> {
      // Todo: Implement Shimmer
    }
    is ResultEM.Failure -> {
      // Todo: Implement Error Handling
    }
    is ResultEM.Success -> {
      val movie = (uiState as ResultEM.Success<CommunityUiModel>).value
      DetailContent(modifier = Modifier, movie = movie, viewModel = viewModel)
    }
  }
}

@Composable
fun DetailContent(modifier: Modifier, movie: CommunityUiModel, viewModel: DetailViewModel) {
  val listState = rememberLazyListState()

  DetailScaffold(modifier = modifier) {
    LazyColumn(state = listState) {
      item { Header(movie = movie, viewModel = viewModel) }
      item { Spacer(modifier = Modifier.requiredHeight(SmallPadding)) }
      item {
        Text(
            text = movie.name ?: "",
            style = MovieDetailTextStyle,
            modifier = Modifier.padding(NormalPadding))
      }
    }
  }
}

@Composable
fun DetailScaffold(
    modifier: Modifier,
    content: @Composable () -> Unit,
) {

  Box(modifier = modifier.fillMaxSize()) {
    Surface(modifier = Modifier.fillMaxSize(), content = content)
  }
}

@Composable
fun Header(movie: CommunityUiModel, viewModel: DetailViewModel) {

  ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
    val (
        image,
        info,
        fab,
        iconComment,
        textComment,
        iconLike,
        textLike,
    ) = createRefs()
    Image(
        painter = rememberAsyncImagePainter(model = movie.name),
        contentDescription = null,
        modifier =
            Modifier.clickable { viewModel.getMovieUseCase }
                .aspectRatio(DetailImageAspectRatio)
                .constrainAs(image) {
                  width = Dimension.fillToConstraints
                  linkTo(
                      start = parent.start, end = parent.end, top = parent.top, bottom = info.top)
                },
        contentScale = ContentScale.Crop)
    Card(
        modifier =
            Modifier.fillMaxWidth().requiredHeight(DetailCardHeight).constrainAs(info) {
              width = Dimension.fillToConstraints
              linkTo(
                  start = parent.start,
                  end = parent.end,
                  top = image.bottom,
                  bottom = parent.bottom)
            },
        shape = RectangleShape) {}

    Icon(
        modifier =
            Modifier.padding(start = NormalPadding, top = SmallPadding)
                .size(DetailIcon)
                .constrainAs(iconComment) {
                  start.linkTo(info.start)
                  top.linkTo(info.top)
                },
        imageVector = Icons.Filled.MailOutline,
        tint = Color.Blue,
        contentDescription = "")
    Text(
        text = movie.name.toString(),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        style = MovieDetailItemTextStyle,
        color = Color.Blue,
        modifier =
            Modifier.padding(start = NormalPadding, top = SmallPadding).constrainAs(textComment) {
              start.linkTo(iconComment.end)
              top.linkTo(iconComment.top)
              bottom.linkTo(iconComment.bottom)
            })
    Icon(
        imageVector = Icons.Outlined.Favorite,
        contentDescription = "",
        tint = Color.Red,
        modifier =
            Modifier.padding(start = NormalPadding, top = SmallPadding)
                .size(DetailIcon)
                .constrainAs(iconLike) {
                  start.linkTo(iconComment.start)
                  top.linkTo(iconComment.bottom)
                },
    )
    Text(
        text = movie.description.toString(),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        style = MovieDetailItemTextStyle,
        color = Color.Red,
        modifier =
            Modifier.padding(start = NormalPadding, top = SmallPadding).constrainAs(textLike) {
              start.linkTo(iconLike.end)
              top.linkTo(iconLike.top)
              bottom.linkTo(iconLike.bottom)
            })

    Box(
        modifier =
            Modifier.constrainAs(fab) {
              end.linkTo(parent.end)
              linkTo(top = info.top, bottom = info.top)
            }) {}
  }
}

@Preview
@Composable
private fun DetailScreenPreview() {
  DetailScreen(communityId = 0, onBackClicked = {})
}
