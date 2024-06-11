package com.example.qrpesa.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qrpesa.R
import com.example.qrpesa.ui.theme.QRPesaTheme

@Composable
fun InitialsCard(
    text: String
){
    Card(
        modifier = Modifier
            .border(BorderStroke(1.dp, MaterialTheme.colorScheme.secondary), shape = CircleShape)
            .size(50.dp),
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()){
            Text(
                text = "SW",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun SuccessCard(){
    Card(
        modifier = Modifier
            //.border(BorderStroke(1.dp, MaterialTheme.colorScheme.primary), shape = CircleShape)
            .size(50.dp),
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.tick_circle),
                contentDescription = "" ,
                modifier = Modifier
                    .size(64.dp)
                    //.padding(15.dp, 0.dp)
                // .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
@Preview
fun PreviewInitialsCard(){
    QRPesaTheme {
        InitialsCard("SW")
    }
}
@Composable
@Preview
fun PreviewSuccessCard(){
    QRPesaTheme {
        SuccessCard()
    }
}