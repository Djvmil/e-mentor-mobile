package com.djvmil.entretienmentor.presentation.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djvmil.entretienmentor.R
import com.djvmil.entretienmentor.presentation.shape.CurveType
import com.djvmil.entretienmentor.presentation.shape.CurvedShape
import com.djvmil.entretienmentor.ui.theme.Purple80
import com.djvmil.entretienmentor.ui.theme.colorPrimary
import com.djvmil.entretienmentor.ui.theme.dark_gray
import com.djvmil.entretienmentor.ui.theme.light_gray

@Composable
fun AuthScreen() {
    Column {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .graphicsLayer {
                    shape = RoundedCornerShape(20.dp)
                    clip = true
                }
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(id = R.drawable.head_auth), contentDescription ="Image Header" )
        }

        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .graphicsLayer {
                    shape = RoundedCornerShape(20.dp)
                    clip = true
                }
                .background(Purple80),
            contentAlignment = Alignment.Center
        ){
            Column(modifier = Modifier
                .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = "Hello, Welcome !",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                    )
                )
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "De l'entraînement à la réussite : \nEntretienMentor vous accompagne.!",
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                    ),
                )

                Spacer(modifier = Modifier.height(120.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .graphicsLayer {
                            shape = RoundedCornerShape(10.dp)
                            clip = true
                        }
                        .background(light_gray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "LOGIN",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                        )
                    )
                }


                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .graphicsLayer {
                            shape = RoundedCornerShape(10.dp)
                            clip = true
                        }
                        .background(light_gray),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "REGISTER",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                        )
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Row(modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Divider(modifier = Modifier.weight(1f), color = Color.Black, thickness = 2.dp)
                    Text(
                        modifier = Modifier.weight(1.5f),
                        text = "Or via social media",
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W900,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                        )
                    )

                    Divider(modifier = Modifier.weight(1f), color = Color.Black, thickness = 2.dp)
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.padding(5.dp).size(40.dp),
                            imageVector = Icons.Rounded.Face,
                            contentDescription = stringResource(id = R.string.Message))

                        Icon(
                            modifier = Modifier.padding(5.dp).size(40.dp),
                            imageVector = Icons.Rounded.Face,
                            contentDescription = stringResource(id = R.string.Message))

                        Icon(
                            modifier = Modifier.padding(5.dp).size(40.dp),
                            imageVector = Icons.Rounded.Face,
                            contentDescription = stringResource(id = R.string.Message))

                }

                Spacer(modifier = Modifier.height(30.dp))
            }
        }
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

@Preview
@Composable
fun AuthScreenPreview(){
    AuthScreen()
}