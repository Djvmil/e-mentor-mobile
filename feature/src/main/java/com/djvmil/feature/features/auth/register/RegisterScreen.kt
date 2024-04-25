package com.djvmil.entretienmentor.presentation.ui.auth.register

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
import com.djvmil.feature.features.CustumTextField
import com.djvmil.feature.features.CustumTextFieldPassword
import com.djvmil.feature.features.HeaderComponent
import com.djvmil.feature.features.TextFieldState
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterScreen(
    openDashboard: () -> Unit,
    viewModel: RegisterViewModel = koinViewModel()
) {
    RegisterContent(openDashboard)
}

@Composable
fun RegisterContent(openDashboard: () -> Unit) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(30.dp),
    ) {
        HeaderComponent(Modifier.padding(vertical = 10.dp)) {
            openDashboard.invoke()
        }

        Text(
            modifier = Modifier.padding(vertical = 5.dp),
            text = "Let's Sign you in",
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.josefin_sans_semibold))
        )

        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = "Welcome",
            fontSize = 25.sp,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
        )

        Text(
            modifier = Modifier,
            text = "By Signing in you are agreeing our",
            color = MaterialTheme.colorScheme.primary,
            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
        )

        Text(
            modifier = Modifier,
            text = "Term and privacy policy",
            color = MaterialTheme.colorScheme.primary,
            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
        )

        CustumTextField(
            modifier = Modifier
                .padding(top = 20.dp),
            textFieldState = TextFieldState(
                text = "Firstname"
            ),
            placeholder = "Enter your firstname"
        ){ value ->

        }

        CustumTextField(
            modifier = Modifier,
            textFieldState = TextFieldState(
                text = "Lastname"
            ),
            placeholder = "Enter your lastname"
        ){ value ->

        }

        CustumTextField(
            modifier = Modifier,
            textFieldState = TextFieldState(
                text = "Phone Number"
            ),
            placeholder = "Enter your phone number"
        ){ value ->

        }

        CustumTextField(
            modifier = Modifier,
            textFieldState = TextFieldState(
                text = "Email"
            ),
            placeholder = "Enter your email"
        ){ value ->

        }

        CustumTextFieldPassword(
            modifier = Modifier,
            textFieldState = TextFieldState(
                text = "Password"
            ),
            placeholder = "Enter your password"
        ){ value ->

        }

        CustumTextFieldPassword(
            modifier = Modifier.padding(bottom = 30.dp),
            textFieldState = TextFieldState(
                text = "Password Confirmation"
            ),
            placeholder = "Confirm your password"
        ){ value -> }

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
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
                    fontWeight = FontWeight.W900,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                )
            )
        }
        
        HorizontalDivider(
            Modifier.padding(vertical = 30.dp)
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
                        text = "Have an account?  ",
                        modifier = Modifier ,
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                        )
                    )
                    Text(
                        text = "Login",
                        modifier = Modifier,
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                        )
                    )

                }

            }
        }

    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark",
)
@Preview(

    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun DefaultPreview() {
    RegisterContent({})
}