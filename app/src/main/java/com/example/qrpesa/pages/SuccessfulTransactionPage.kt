package com.example.qrpesa.pages


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qrpesa.R
import com.example.qrpesa.components.Icon
import com.example.qrpesa.components.InitialsCard
import com.example.qrpesa.components.LargeText
import com.example.qrpesa.components.MediumText
import com.example.qrpesa.components.MediumTextBold
import com.example.qrpesa.components.SharedButton
import com.example.qrpesa.components.SmallText
import com.example.qrpesa.components.SuccessCard
import com.example.qrpesa.ui.theme.QRPesaTheme

@Composable
fun SuccessfulTransactionPage(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        //verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            Icon(icon = painterResource(id = R.drawable.close) )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row {
            InitialsCard()
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row (

        ){
            LargeText(text = "TREATS BY WENDOH")
        }
        Row {
            LargeText(text = "TILL NUMBER 8811788")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row (
            verticalAlignment = Alignment.Bottom
        ){
            MediumText(text = "KSH, 200.00")
            Spacer(modifier = Modifier.width(10.dp))
            SmallText(text = "FEE: KSH 0.00")
        }
        Spacer(modifier = Modifier.height(200.dp))
        Row (
            horizontalArrangement = Arrangement.Center
        ){
            SuccessCard()
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            MediumTextBold(text = "Your transaction is successful")
        }
        Row {
            MediumTextBold(text = "ID: SEV2ZAABF6")
        }
        Spacer(modifier = Modifier.height(130.dp))
        Row {
            SharedButton()
        }
    }
}

@Composable
@Preview
fun PreviewSuccessfulTransactionPage(){
    QRPesaTheme {
        SuccessfulTransactionPage()
    }
}