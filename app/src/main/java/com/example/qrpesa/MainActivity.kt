package com.example.qrpesa

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qrpesa.pages.SuccessfulTransactionPage
import com.example.qrpesa.ui.theme.QRPesaTheme

class MainActivity : ComponentActivity() {

    private var tillNumber: String? = null
    private var amount: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntent(intent)
        setContent {
            QRPesaTheme {
                //SuccessfulTransactionPage()
                //QRPesaApp(tillNumber, amount)
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }
    //Extract data from the URL and process the payment.
    private fun handleIntent(intent: Intent?){
        intent?.data?.let {
            uri ->
            tillNumber = uri.getQueryParameter("till")
            amount = uri.getQueryParameter("amount")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QRPesaApp(tillNumber: String?, amount: String?) {
    var pin by remember { mutableStateOf("") }
    var confirmed by remember { mutableStateOf(false) }
    var transactionMessage by remember { mutableStateOf("") }

    if (confirmed) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Transaction to Till: $tillNumber")
            Text(text = "Amount: $amount")
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = pin,
                onValueChange = { pin = it },
                label = { Text("Enter PIN") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    if (pin == "1234") { // Dummy check for PIN, replace with actual logic
                        transactionMessage = "Payment of $amount to till $tillNumber successful!"
                    } else {
                        transactionMessage = "Incorrect PIN. Please try again."
                    }
                    confirmed = false
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirm Payment")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = transactionMessage)
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Pay to Till: $tillNumber")
            Text(text = "Amount: $amount")
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    confirmed = true
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Proceed to Payment")
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QRPesaTheme {
        Greeting("Android")
    }
}