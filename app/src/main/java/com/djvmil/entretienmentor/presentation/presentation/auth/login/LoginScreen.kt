package com.djvmil.entretienmentor.presentation.presentation.auth.login

import android.content.res.Configuration
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
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
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
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    openDashboard: () -> Unit,
    viewModel: LoginViewModel = koinViewModel()
) {
        LoginContent()

}

@Composable
fun LoginContent(){

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(30.dp),
    ) {
        HeaderComponent(modifier = Modifier.padding(bottom = 20.dp)) {}

        Text(
            modifier = Modifier.padding(vertical = 5.dp),
            text = "Let's Sign you in",
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.josefin_sans_semibold))
        )

        Text(
            modifier = Modifier.padding(vertical = 5.dp),
            text = "Welcome back",
            fontSize = 25.sp,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
        )

        Text(
            modifier = Modifier.padding(vertical = 5.dp),
            text = "You've been missed!",
            fontSize = 25.sp,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
        )


        Text(
            modifier = Modifier.padding(top = 30.dp),
            text = "Username or Email",
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
                        text = "Register",
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
                        text = "Login",
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
    LoginContent()
}