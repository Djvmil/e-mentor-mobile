package com.djvmil.entretienmentor.presentation.presentation.auth.login

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.djvmil.entretienmentor.ui.theme.*
import com.djvmil.entretienmentor.R
import com.djvmil.entretienmentor.presentation.presentation.auth.CustomEditText
import com.djvmil.entretienmentor.presentation.shape.CurveType
import com.djvmil.entretienmentor.presentation.shape.CurvedShape
import com.djvmil.entretienmentor.presentation.shape.placeAt
import kotlin.math.roundToInt

@Composable
fun LoginScreen(openDashboard: () -> Unit) {

    val density = LocalDensity.current
    val loginY = density.run { 510.dp.toPx() }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {

        TopAuthPage(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .placeAt(0,0))
        BottomAuthPage(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .placeAt(0,loginY.roundToInt()))
    }

}

@Composable
fun TopAuthPage(modifier: Modifier) {
    var text by remember {
        mutableStateOf("")
    }

    Box(
        modifier = modifier
            .graphicsLayer {
                shape = CurvedShape(CurveType.LTR)
                clip = true
            }
            .background(colorPrimary)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(modifier = Modifier.padding(10.dp)){
                Image(painter = painterResource(id = R.drawable.head_auth), contentDescription ="Image Header" )
            }

            Text(
                modifier = Modifier,
                text = "Welcome",
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.josefin_sans_semibold))
            )

            Text(
                modifier = Modifier,
                text = "By Signing in you are agreeing our",
                fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
            )

            Text(
                modifier = Modifier,
                text = "Term and privacy policy",
                fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
            )

            CustomEditText(
                hint = "Enter your email",
                icon = Icons.Rounded.Person
            )
            CustomEditText(
                hint = "Enter your password",
                icon = Icons.Rounded.Lock
            )

        }
    }
}

@Composable
fun BottomAuthPage(modifier: Modifier) {
    Box(
        modifier = modifier
            .graphicsLayer {
                shape = CurvedShape(CurveType.RTL)
                clip = true
            }
            .background(colorPrimary)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Already have an account?",
                modifier = Modifier.padding(start = 18.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .graphicsLayer {
                        shape = RoundedCornerShape(100.dp)
                        clip = true
                    }
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "LOGIN",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.W900
                    )
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen(openDashboard = {})
}