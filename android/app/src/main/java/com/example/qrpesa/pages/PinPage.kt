package com.example.qrpesa.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.qrpesa.R
import com.example.qrpesa.components.Icon
import com.example.qrpesa.components.InitialsCard
import com.example.qrpesa.components.LargeText
import com.example.qrpesa.components.MediumText
import com.example.qrpesa.components.PinFields
import com.example.qrpesa.components.SharedButton
import com.example.qrpesa.components.SmallText
import com.example.qrpesa.navigation.Screen
import com.example.qrpesa.ui.theme.QRPesaTheme

@Composable
fun PinPage(
    tillNumber: String?,
    amount: String?,
    navController: NavController,
){
    var pin by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        //verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(icon = painterResource(id = R.drawable.close))
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row {
            InitialsCard("TW")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(

        ) {
            LargeText(text = "TREATS BY WENDOH")
        }
        Row {
            LargeText(text = "TILL NUMBER $tillNumber")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            MediumText(text = "KSH, $amount")
            Spacer(modifier = Modifier.width(10.dp))
            SmallText(text = "FEE: KSH 0.00")
        }
        Spacer(modifier = Modifier.height(70.dp))
        Row(
        ) {
            LargeText(text = "ENTER MPESA PIN")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            PinFields(pin)
        }
        Spacer(modifier = Modifier.height(30.dp))
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
            Spacer(modifier = Modifier.height(25.dp))
            Row {
                SharedButton(
                    text = "Pay",
                    onclick = {
                        if (pin == "1234") { // Dummy check for PIN, replace with actual logic
                            navController.navigate(route = Screen.Screen.SuccessfulTransaction.route)
                        } else {
                            //transactionMessage = "Incorrect PIN. Please try again."
                        }
                    },
                )
            }

        }
    }
}

@Composable
@Preview
fun PreviewPinPage(){
    QRPesaTheme {
        PinPage("8811788", "200", navController = rememberNavController())
    }
}