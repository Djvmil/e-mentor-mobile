package com.djvmil.entretienmentor.presentation.presentation.auth.register

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djvmil.entretienmentor.R
import com.djvmil.entretienmentor.presentation.presentation.auth.login.BottomAuthPage
import com.djvmil.entretienmentor.presentation.presentation.auth.login.TopAuthPage
import com.djvmil.entretienmentor.presentation.shape.CurveType
import com.djvmil.entretienmentor.presentation.shape.CurvedShape
import com.djvmil.entretienmentor.presentation.shape.placeAt
import kotlin.math.roundToInt

@Composable
fun RegisterScreen(openDashboard: () -> Unit) {


    val density = LocalDensity.current
    val loginY = density.run { -20.dp.toPx() }

    Column(modifier = Modifier.fillMaxSize() ) {
        TopRegisterPage(
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp)
                .placeAt(0,0))

        BottomRegisterPage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .placeAt(0, loginY.roundToInt()))
    }

}

@Composable
fun TopRegisterPage(modifier: Modifier) {
    var text by remember {
        mutableStateOf("")
    }


    Box(
        modifier = modifier
            .graphicsLayer {
                shape = CurvedShape(CurveType.LTR)
                clip = true
            }
            .background(MaterialTheme.colorScheme.background)
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


            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                value = "Enter your firstname",
                onValueChange = {})

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                value = "Enter your lastname",
                onValueChange = {})

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                value = "Enter your email",
                onValueChange = {})

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                value = "Enter your password",
                onValueChange = {})

            Box(
                modifier = Modifier
                    .padding(15.dp)
                    .align(Alignment.End)
                    .size(70.dp)
                    .graphicsLayer {
                        shape = RoundedCornerShape(45.dp)
                        clip = true
                    }
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Outlined.ArrowForward,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    contentDescription = "Register Button")
            }

        }
    }
}

@Composable
fun BottomRegisterPage(modifier: Modifier) {
    Box(
        modifier = modifier
            .graphicsLayer {
                shape = CurvedShape(CurveType.RTL)
                clip = true
            }
            .background(MaterialTheme.colorScheme.background)
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.primary,
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
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "LOGIN",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.W900
                    )
                )
            }
        }
    }

}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun DefaultPreview() {
    RegisterScreen(openDashboard = {})
}