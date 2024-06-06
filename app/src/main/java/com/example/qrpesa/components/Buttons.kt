package com.example.qrpesa.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qrpesa.ui.theme.QRPesaTheme

@Composable
fun SharedButton(){
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier
            .height(65.dp)
            .width(320.dp)
    ) {
        Text(text = "Filled")

    }
}

@Composable
@Preview
fun PreviewSharedButton(){
    QRPesaTheme {
        SharedButton()
    }
}