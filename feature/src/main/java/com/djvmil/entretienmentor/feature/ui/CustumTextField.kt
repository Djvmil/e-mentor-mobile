package com.djvmil.entretienmentor.feature.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djvmil.entretienmentor.feature.R

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    shape: RoundedCornerShape = RoundedCornerShape(10.dp),
    errorText1: String? = null,
    title: String? = null,
    readOnly: Boolean = false,
    @DrawableRes leadingIconId: Int? = null,
    @DrawableRes trailingIconId: Int? = null,
    onValueChange: (String) -> Unit
) {
    var value by rememberSaveable { mutableStateOf("") }
    var errorText by rememberSaveable { mutableStateOf(errorText1) }

    Column(
        modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth()) {
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

        val trailingIcon: (@Composable () -> Unit)? = if (trailingIconId != null) {
            { Icon(painter = painterResource(id = trailingIconId), "Icon") }
        } else null

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            shape = shape,
            placeholder = { placeholder?.let { Text(text = it) } },
            value = value,
            supportingText = { placeholder?.let { Text(text = it) } },
            onValueChange = {
                value = it
                onValueChange(it)
            },
            readOnly = readOnly,
            singleLine = true,
            isError = !errorText.isNullOrBlank(),
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon
        )

        if (!errorText.isNullOrBlank()) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
                text = errorText!!,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp,
                textAlign = TextAlign.Start
            )
        }
    }
}


@Preview
@Composable
fun CustumTextFieldPreview(){
/*
    Column {
        CustumTextField(
            modifier = Modifier,
            value = ""
        ){}
        CustumTextField(
            modifier = Modifier,
            value = ""
        ){}
        CustumTextField(
            modifier = Modifier,
            value = ""
        ){}
    }*/
}