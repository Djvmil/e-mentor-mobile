package com.djvmil.entretienmentor.feature.ui.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djvmil.entretienmentor.feature.R
import com.djvmil.entretienmentor.feature.ui.CustomTextField
import com.djvmil.entretienmentor.feature.ui.CustomTextFieldPassword
import com.djvmil.entretienmentor.feature.ui.HeaderComponent
import com.djvmil.entretienmentor.feature.ui.LoadingAnimation
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    openDashboard: () -> Unit,
    viewModel: LoginViewModel = koinViewModel()
) {
    LoginContent(
        buttonEnabled = { viewModel.loginState.isInputValid },
        onUsernameInputChanged = viewModel::onUsernameInputChange,
        onPasswordInputChange = viewModel::onPasswordInputChange,
        onLoginButtonClick = viewModel::onLoginClick,
        errorHint = { viewModel.loginState.errorMessageLoginProcess },
        errorUsernameHint = { viewModel.loginState.errorUsernameInput },
        isLoading = true
    ){
        openDashboard.invoke()
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LoginContent(
    buttonEnabled: () -> Boolean,
    onUsernameInputChanged: (String) -> Unit,
    onPasswordInputChange: (String) -> Unit,
    onLoginButtonClick: () -> Unit,
    errorHint: () -> String?,
    errorUsernameHint: () -> String?,
    isLoading: Boolean = false,
    openDashboard: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(30.dp),
        ) {
            HeaderComponent(modifier = Modifier.padding(bottom = 20.dp)) { openDashboard.invoke() }

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

            CustomTextField(
                modifier = Modifier
                    .padding(top = 30.dp),
                title = "Username or Email",
                placeholder = "Enter your username or email",
                errorText = errorUsernameHint.invoke(),
                onValueChange = onUsernameInputChanged
            )

            CustomTextFieldPassword(
                modifier = Modifier,
                title = "Password",
                placeholder = "Enter your password",
                onValueChange = onPasswordInputChange
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                if (!errorHint.invoke().isNullOrBlank()){
                    Text(
                        modifier = Modifier.padding(vertical = 5.dp),
                        text = errorHint.invoke().toString(),
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.error,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                    )
                }
            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clickable(buttonEnabled.invoke()) { onLoginButtonClick.invoke() }
                .graphicsLayer {
                    shape = RoundedCornerShape(10.dp)
                    clip = true
                }
                .then(
                    if (buttonEnabled.invoke())
                        Modifier.background(MaterialTheme.colorScheme.primary)
                    else Modifier.background(MaterialTheme.colorScheme.primary.copy(0.5f))
                ),
                contentAlignment = Alignment.Center){

                Text(
                    modifier = Modifier,
                    text = "Login",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.W900,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                    )
                )
            }
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
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                            )
                        )
                        Text(
                            text = "Register",
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


        LoadingAnimation(
            modifier = Modifier
                .background(
                    MaterialTheme
                        .colorScheme
                        .primary
                        .copy(0.5f)
                )
                .fillMaxSize(),
            isLoading = isLoading
        )
    }
}

@PreviewLightDark
@Composable
fun DefaultPreview() {
    LoginContent(
        { true },
        {},
        {},
        {},
        {""},
        {""},
        false,
        {}
    )
}

@Preview(showBackground = true, widthDp = 700, heightDp = 500)
@Composable
fun DefaultPreviewTablet() {
    LoginContent(
        { true },
        {},
        {},
        {},
        {""},
        {""},
        true,
        {}
    )
}