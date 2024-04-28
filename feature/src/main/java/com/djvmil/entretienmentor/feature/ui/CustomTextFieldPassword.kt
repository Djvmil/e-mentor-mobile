package com.djvmil.entretienmentor.feature.ui

import androidx.annotation.DrawableRes
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
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djvmil.entretienmentor.feature.R

@Composable
fun CustomTextFieldPassword(
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    shape: RoundedCornerShape = RoundedCornerShape(10.dp),
    errorText: String? = null,
    title: String? = null,
    readOnly: Boolean = false,
    @DrawableRes leadingIconId: Int? = null,
    disableTrailingIcon: Boolean = false,
    onValueChange: (String) -> Unit
) {
    var value by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(modifier.padding(vertical = 5.dp).fillMaxWidth()) {

        if (title != null){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
            )
        }

        val leadingIcon: (@Composable () -> Unit)? = if (leadingIconId != null) {
            { Icon(painter = painterResource(id = leadingIconId), "Icon") }
        } else null


        val trailingIcon: (@Composable () -> Unit)? = if (!disableTrailingIcon) {
            {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                // Localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                // Toggle button to hide or display password
                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(imageVector  = image, description)
                }
            }
        } else null

        OutlinedTextField(
            modifier = modifier.fillMaxWidth(),
            shape = shape,
            placeholder = { placeholder?.let { Text(text = it) } },
            readOnly = readOnly,
            value = value,
            onValueChange = {
                value = it
                onValueChange(it)
            },
            singleLine = true,
            isError = !errorText.isNullOrBlank(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon

        )
        if (!errorText.isNullOrBlank()) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
                text = errorText,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                textAlign = TextAlign.Justify
            )
        }
    }
}