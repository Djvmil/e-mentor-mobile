package com.djvmil.entretienmentor.presentation.presentation.auth

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@Composable
fun CustomEditText(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .border(width = 1.5.dp, color = Color.Black, RoundedCornerShape(12.dp)),
    hint: String = "Hi enter your text",
    contentDesc: String = "Content Description",
    icon: ImageVector
){
    var input by remember { mutableStateOf("") }
    val passwordHidden by rememberSaveable { mutableStateOf(true) }

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