package com.example.qrpesa.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qrpesa.ui.theme.QRPesaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PinFields(){
    var pin by remember {
        mutableStateOf("")
    }
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Spacer(modifier = Modifier.width(8.dp))
        for (i in 0 until 4){
            TextField(
                value = if (i < pin.length) pin[i].toString() else "",
                onValueChange = {},
                readOnly = false,
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
                        shape = CircleShape
                    ),
                shape = CircleShape,
                colors = TextFieldDefaults.textFieldColors(
                    //textColor = Color.White,
                    containerColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
@Preview
fun PreviewPinFields(){
    QRPesaTheme {
        PinFields()
    }
}