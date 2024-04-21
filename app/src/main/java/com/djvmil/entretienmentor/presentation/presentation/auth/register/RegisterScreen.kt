package com.djvmil.entretienmentor.presentation.presentation.auth.register

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.HorizontalDivider
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
import com.djvmil.entretienmentor.presentation.presentation.HeaderComponent
import com.djvmil.entretienmentor.presentation.shape.CurveType
import com.djvmil.entretienmentor.presentation.shape.CurvedShape

@Composable
fun RegisterScreen(openDashboard: () -> Unit) {
    RegisterContent()

}


@Composable
fun RegisterContent(){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(30.dp),
    ) {
        HeaderComponent(Modifier.padding(vertical = 10.dp)) {

        }

        Text(
            modifier = Modifier.padding(vertical = 5.dp),
            text = "Let's Sign you in",
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.josefin_sans_semibold))
        )

        Text(
            modifier = Modifier.padding(vertical = 5.dp),
            text = "Welcome",
            fontSize = 25.sp,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
        )


        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = "Firstname",
            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
        )

        var value = ""
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.dp),
            shape = RoundedCornerShape(10.dp),
            value = value,
            placeholder = { "Enter your email" },
            onValueChange = {})

        Text(
            modifier = Modifier,
            text = "Lastname",
            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            shape = RoundedCornerShape(10.dp),
            placeholder = { "Enter your password" },
            value = value,
            onValueChange = {})

        Text(
            modifier = Modifier,
            text = "Phone Number",
            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            shape = RoundedCornerShape(10.dp),
            placeholder = { "Enter your password" },
            value = value,
            onValueChange = {})

        Text(
            modifier = Modifier,
            text = "Email",
            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            shape = RoundedCornerShape(10.dp),
            placeholder = { "Enter your password" },
            value = value,
            onValueChange = {})

        Text(
            modifier = Modifier,
            text = "Password",
            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            shape = RoundedCornerShape(10.dp),
            placeholder = { "Enter your password" },
            value = value,
            onValueChange = {})

        HorizontalDivider(
            Modifier.padding(vertical = 20.dp)
        )

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier
                    .padding(5.dp)
                    .size(40.dp),
                imageVector = Icons.Rounded.Face,
                contentDescription = stringResource(id = R.string.Message)
            )

            Icon(
                modifier = Modifier
                    .padding(5.dp)
                    .size(40.dp),
                imageVector = Icons.Rounded.Face,
                contentDescription = stringResource(id = R.string.Message)
            )

            Icon(
                modifier = Modifier
                    .padding(5.dp)
                    .size(40.dp),
                imageVector = Icons.Rounded.Face,
                contentDescription = stringResource(id = R.string.Message)
            )

        }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter,
        ) {

            Column(modifier = Modifier) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 3.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        text = "Don't have an account?  ",
                        modifier = Modifier ,
                        style = TextStyle(
                            textAlign = TextAlign.Center
                        )
                    )
                    Text(
                        text = "Login",
                        modifier = Modifier,
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center
                        )
                    )

                }


                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .graphicsLayer {
                        shape = RoundedCornerShape(10.dp)
                        clip = true
                    }
                    .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center){

                    Text(
                        modifier = Modifier,
                        text = "REGISTER",
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