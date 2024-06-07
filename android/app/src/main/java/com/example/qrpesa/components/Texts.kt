package com.example.qrpesa.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.qrpesa.ui.theme.QRPesaTheme

@Composable
fun LargeText(
    text: String
){
    Text(text = text,
        color = MaterialTheme.colorScheme.primary,
        fontSize = 16.sp,

    )
}
@Composable
fun MediumText(
    text: String
){
    Text(text = text,
        color = MaterialTheme.colorScheme.primary,
        fontSize = 14.sp,

        )
}
@Composable
fun MediumTextBold(
    text: String
){
    Text(text = text,
        color = MaterialTheme.colorScheme.primary,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold

        )
}
@Composable
fun SmallText(
    text: String
){
    Text(text = text,
        color = MaterialTheme.colorScheme.primary,
        fontSize = 12.sp,

        )
}

@Composable
@Preview
fun PreviewLargeText(){
    QRPesaTheme {
        LargeText(text ="TREATS BY WENDOH")
    }
}
@Composable
@Preview
fun PreviewMediumText(){
    QRPesaTheme {
        MediumText(text ="TREATS BY WENDOH")
    }
}
@Composable
@Preview
fun PreviewMediumTextBold(){
    QRPesaTheme {
        MediumTextBold(text ="TREATS BY WENDOH")
    }
}
@Composable
@Preview
fun PreviewSmallText(){
    QRPesaTheme {
        SmallText(text ="TREATS BY WENDOH")
    }
}