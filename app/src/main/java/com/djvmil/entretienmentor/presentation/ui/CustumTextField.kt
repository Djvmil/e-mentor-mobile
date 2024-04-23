package com.djvmil.entretienmentor.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.djvmil.entretienmentor.R

@Composable
fun CustumTextField(modifier: Modifier = Modifier, textFieldState: TextFieldState? = null, placeholder: String? = null, shape: RoundedCornerShape = RoundedCornerShape(10.dp), onValueChange: (String) -> Unit) {
    var value by rememberSaveable { mutableStateOf("") }
    Column(modifier.padding(vertical = 5.dp).fillMaxWidth()) {
        if (textFieldState?.text != null){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = textFieldState.text,
                fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
            )
        }

        val trailingIcon: (@Composable () -> Unit)? = if (textFieldState?.icon != null) {
            { Icon(painter = painterResource(id = textFieldState.icon), "Icon") }
        } else null

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            shape = shape,
            placeholder = { placeholder ?: placeholder?.let { Text(text = it) } },
            value = value,
            onValueChange = {
                value = it
                onValueChange(it)
            },
            isError = !textFieldState?.error.isNullOrBlank(),
            trailingIcon = trailingIcon
        )
        if (!textFieldState?.error.isNullOrBlank()) {
            Text(
                text = textFieldState?.error ?: "",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Preview
@Composable
fun CustumTextFieldPreview(){

    Column {
        CustumTextField(
            modifier = Modifier,
        ){}
        CustumTextField(
            modifier = Modifier,
        ){}
        CustumTextField(
            modifier = Modifier,
        ){}
    }
}