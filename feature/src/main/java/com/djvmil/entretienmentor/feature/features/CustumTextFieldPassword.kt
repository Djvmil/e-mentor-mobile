package com.djvmil.feature.features

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.djvmil.feature.R

@Composable
fun CustumTextFieldPassword(modifier: Modifier = Modifier, textFieldState: TextFieldState, placeholder: String? = null, shape: RoundedCornerShape = RoundedCornerShape(10.dp), onValueChange: (String) -> Unit) {
    var value by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    Column(modifier.padding(vertical = 5.dp).fillMaxWidth()) {
        if (textFieldState.text != null){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = textFieldState.text,
                fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
            )
        }

        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth() ,
            shape = shape,
            placeholder = { placeholder?.let { Text(text = it) } },
            value = value,
            readOnly = textFieldState.readOnly,
            onValueChange = {
                value = it
                onValueChange(it)
            },
            isError = !textFieldState.error.isNullOrBlank(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                // Localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                // Toggle button to hide or display password
                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(imageVector  = image, description)
                }
            },

        )
        if (!textFieldState.error.isNullOrBlank()) {
            Text(
                text = textFieldState.error,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.error,
                fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                textAlign = TextAlign.Justify,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}