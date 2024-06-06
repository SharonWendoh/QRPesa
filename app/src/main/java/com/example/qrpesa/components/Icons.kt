package com.example.qrpesa.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qrpesa.R
import com.example.qrpesa.ui.theme.QRPesaTheme

@Composable
fun Icon(
    icon: Painter
)
{
    Column(modifier = Modifier
        .size(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = icon,
            contentDescription = "" ,
            modifier = Modifier
                .size(24.dp)

        )
    }
}
@Composable
@Preview
fun PreviewIcon(){
    QRPesaTheme {
        Icon(icon = painterResource(id = R.drawable.close))
    }
}