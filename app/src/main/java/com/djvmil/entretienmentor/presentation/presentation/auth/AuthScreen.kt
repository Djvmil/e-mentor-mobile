package com.djvmil.entretienmentor.presentation.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.compose.rememberNavController
import com.djvmil.entretienmentor.R
import com.djvmil.entretienmentor.ui.navigation.NavigationActions
import com.djvmil.entretienmentor.ui.theme.background
import com.djvmil.entretienmentor.ui.theme.light_gray

@Composable
fun AuthScreen(navActions: NavigationActions) {

    Column {
        TopAuthPage()
        BottomAuthPage(navActions)
    }

}

@Composable
fun TopAuthPage() {
    Column {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .graphicsLayer {
                    shape = RoundedCornerShape(20.dp)
                    clip = true
                },
            contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(id = R.drawable.head_auth), contentDescription ="Image Header" )
        }

    }
}

@Composable
fun BottomAuthPage(navActions: NavigationActions) {

    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .graphicsLayer {
                shape = RoundedCornerShape(20.dp)
                clip = true
            },
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
                    .clickable { navActions.navigateToLogin() }
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
                    .clickable { navActions.navigateToRegister() }
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
                    modifier = Modifier
                        .padding(5.dp)
                        .size(40.dp),
                    imageVector = Icons.Rounded.Face,
                    contentDescription = stringResource(id = R.string.Message))

                Icon(
                    modifier = Modifier
                        .padding(5.dp)
                        .size(40.dp),
                    imageVector = Icons.Rounded.Face,
                    contentDescription = stringResource(id = R.string.Message))

                Icon(
                    modifier = Modifier
                        .padding(5.dp)
                        .size(40.dp),
                    imageVector = Icons.Rounded.Face,
                    contentDescription = stringResource(id = R.string.Message))

            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }

}

@Preview
@Composable
fun AuthScreenPreview(){
    AuthScreen(NavigationActions(rememberNavController()))
}
