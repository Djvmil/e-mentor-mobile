package com.djvmil.entretienmentor.presentation.presentation.auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djvmil.entretienmentor.R
import com.djvmil.entretienmentor.presentation.shape.CurveType
import com.djvmil.entretienmentor.presentation.shape.CurvedShape
import com.djvmil.entretienmentor.presentation.shape.placeAt
import kotlin.math.roundToInt

@Composable
fun AuthScreen() {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(modifier = Modifier.padding(10.dp)){
                Image(painter = painterResource(id = R.drawable.quadrangle_background), contentDescription ="Image Header" )
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

            CustomText(
                hint = "Enter your email",
                icon = Icons.Rounded.Person
            )
            CustomText(
                hint = "Enter your password",
                icon = Icons.Rounded.Lock
            )

        }
    }
}




@Composable
fun CustomText(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .border(width = 1.5.dp, color = Color.Black, RoundedCornerShape(12.dp)),
    hint: String = "Hi enter your text",
    contentDesc: String = "Content Description",
    icon: ImageVector
){
    var input by remember { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        BasicTextField(
            modifier = modifier.fillMaxWidth(),
            value = input,
            textStyle = MaterialTheme.typography.headlineSmall,
            onValueChange = {
                input = it
            },
            visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
            //  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            maxLines = 1,
            decorationBox = { innerTextField ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Text(text = hint)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            icon,
                            contentDescription = contentDesc,
                            Modifier
                                .padding(start = 8.dp)
                                .size(25.dp)

                        )
                        //this must be called once and in any part of this lambda we want to put it
                        innerTextField()

                        Icon(
                            Icons.Rounded.Check,
                            contentDescription = "",
                            Modifier
                                .padding(end = 8.dp)
                                .size(25.dp)
                        )

                    }
                }

            }
        )
    }


}

@Composable
fun LoginScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Logo or top image would go here
            Text("Welcome", style = MaterialTheme.typography.displayMedium)

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Email Address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Checkbox(
                    checked = false,
                    onCheckedChange = {}
                )
                Text("Remember password")

                TextButton(onClick = { /*TODO: Handle forget password*/ }) {
                    Text("Forget password")
                }
            }

            Button(
                onClick = { /*TODO: Handle login*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Login")
            }

            TextButton(onClick = { /*TODO: Handle register*/ }) {
                Text("Register")
            }

            // Social Media Buttons
            Row {
                IconButton(onClick = { /*TODO: Handle social login*/ }) {
                    Icon(imageVector = ImageVector.vectorResource(id = R.drawable.outline_bell), contentDescription = "Facebook Login")
                }
                // Repeat for other social media icons
            }
        }
    }
}

@Composable
fun CustomShapeCanvas() {
    val density = LocalDensity.current
    val loginY = density.run { 510.dp.toPx() }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
/*
        var modifier = Modifier.fillMaxWidth().background(Color.Cyan)

        SignUp(
            modifier = modifier
                .height(600.dp)
                .graphicsLayer {
                    shape = CurvedShape(CurveType.RTL)
                    clip = true
                }
                .placeAt(0,0)
        )

        SignIn(
            modifier = modifier
                .height(250.dp)
                .graphicsLayer {
                    shape = CurvedShape(CurveType.LTR)
                    clip = true
                }
                .placeAt(0,loginY.roundToInt())
        )*/

        var modifier = Modifier.fillMaxWidth()

        SignUp(
            modifier = modifier
                .graphicsLayer {
                    shape = CurvedShape(CurveType.LTR)
                    clip = true
                }
                .height(600.dp)
                .placeAt(0,0)
        )
        SignIn(
            modifier = modifier
                .height(250.dp)
                .placeAt(0, loginY.roundToInt())
        )
    }
}

@Composable
fun SignUp(modifier: Modifier) {
    var text by remember {
        mutableStateOf("")
    }

    Box(
        modifier = modifier
            .background(Color.Cyan)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Name",
                modifier = Modifier.padding(start = 18.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = {
                    text = it
                },
                label = {
                    Text(
                        "Enter name",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.W900
                        ),
                    )
                },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.W900
                ),
                leadingIcon = {
                    Icon(
                        Icons.Default.Person,
                        "",
                        tint = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Email",
                modifier = Modifier.padding(start = 18.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = {
                    text = it
                },
                label = {
                    Text(
                        "Enter email",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.W900
                        ),
                    )
                },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.W900
                ),
                leadingIcon = {
                    Icon(
                        Icons.Default.Email,
                        "",
                        tint = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Password",
                modifier = Modifier.padding(start = 18.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = {
                    text = it
                },
                label = {
                    Text(
                        "Enter password",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.W900
                        ),
                    )
                },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.W900
                ),
                leadingIcon = {
                    Icon(
                        Icons.Default.Lock,
                        "",
                        tint = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = true, onCheckedChange = {})
                Text(
                    text = "Agree to our terms and conditions",
                    modifier = Modifier.padding(start = 8.dp),
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.BottomEnd
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .graphicsLayer {
                            shadowElevation = 12.dp.toPx()
                            clip = true //make sure to set clip to true
                            shape = CircleShape
                        }
                        .background(Color.Blue),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.ArrowForward,
                        "",
                        modifier = Modifier.size(30.dp),
                        tint = Color.White
                    )
                }
            }
        }
    }

}

@Composable
fun SignIn(modifier: Modifier) {
    Box(
        modifier = modifier
            .graphicsLayer {
                shape = CurvedShape(CurveType.RTL)
                clip = true
            }
            .background(Color.Cyan)
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
    CustomShapeCanvas()
}
