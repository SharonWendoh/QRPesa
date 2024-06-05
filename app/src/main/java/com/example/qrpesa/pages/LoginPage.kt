package com.example.qrpesa.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun QRPesaLogin() {
    // State variable for storing the PIN
    var pin by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = "SH",
                style = MaterialTheme.typography.h5,
                color = Color.White
            )
            Text(
                text = "Sharon Wendoh",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Text(
                text = "0702020101",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "Enter Mpesa Pin",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 0 until 4) {
                    TextField(
                        value = if (i < pin.length) pin[i].toString() else "",
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .size(50.dp)
                            .border(1.dp, Color.White, shape = CircleShape),
                        textStyle = MaterialTheme.typography.h4.copy(color = Color.White),
                        singleLine = true,
                        shape = CircleShape,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Black,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Number pad
            Column {
                val numberPad = listOf(
                    listOf("1", "2", "3"),
                    listOf("4", "5", "6"),
                    listOf("7", "8", "9"),
                    listOf("Cancel", "0", "Enter")
                )

                numberPad.forEach { row ->
                    Row(
                        modifier = Modifier.padding(top = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        row.forEach { label ->
                            Button(
                                onClick = {
                                    when (label) {
                                        "Cancel" -> pin = ""
                                        "Enter" -> {
                                            // Handle enter action, such as verifying the PIN
                                        }
                                        else -> if (pin.length < 4) {
                                            pin += label
                                        }
                                    }
                                },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(text = label)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewQRPesaLogin() {
    QRPesaLogin()
}
