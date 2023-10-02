package com.example.tipcalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Button(
    symbol: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Cyan)
            .clickable { onClick() }
            .border(4.dp, Color.Black)
            .then(modifier),
    ) {
        Text(
            text = symbol,
            color = Color.Black,
            fontSize = 50.sp,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun Header(
    amount: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)

        ) {
            Text(
                text = "Total Per Person",
                fontSize = 30.sp
            )
            Text(
                text = "$ $amount", // "%.2f".format()
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterBillField(
    amount: String,
    onClick: () -> Unit,
    onValueChange: (String) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        OutlinedTextField(
            value = amount,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions.Default,
            label = { Text(text = "The Amount") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.AttachMoney,
                    contentDescription = "icon"
                )
            },
            onValueChange = { onValueChange(it) },
        )
        Icon(
            imageVector = Icons.Rounded.Clear,
            contentDescription = "icon",
            modifier = Modifier
                .clickable { onClick() }
                .padding(8.dp)
        )
    }
}


@Composable
fun SplitRow(number: Int, onClickPlus: () -> Unit, onClickMinus: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Split",
            fontSize = 30.sp,
            modifier = Modifier.weight(3f)
        )
        Button(
            symbol = "-",
            modifier = Modifier.weight(1f)
        ) {
            onClickMinus()
        }
        Text(
            text = number.toString(),
            fontSize = 30.sp,
            modifier = Modifier.weight(1f)
        )
        Button(
            symbol = "+",
            modifier = Modifier.weight(1f)
        ) {
            onClickPlus()
        }

    }
}

@Composable
fun TipRow(number: Int, onClickPlus: () -> Unit, onClickMinus: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Tip",
            fontSize = 30.sp,
            modifier = Modifier.weight(3f)
        )
        Button(
            symbol = "-",
            modifier = Modifier.weight(1f)
        ) {
            onClickMinus()
        }
        Text(
            text = number.toString(),
            fontSize = 30.sp,
            modifier = Modifier.weight(1f)
        )
        Button(
            symbol = "+",
            modifier = Modifier.weight(1f)
        ) {
            onClickPlus()
        }
    }

}


@Preview(showBackground = true)
@Composable
fun buttonPreview() {
    Button(symbol = "+") {
    }
}

@Preview(showBackground = false)
@Composable
fun ResultCardPreview() {
    Header("123.5")
}

@Preview(showBackground = true)
@Composable
fun EnterBillFieldPreview() {
    EnterBillField(amount = "1233", onClick = {}, onValueChange = {})
}

@Preview(showBackground = true)
@Composable
fun SplitRowPreview(
) {
    SplitRow(2, onClickPlus = {}, onClickMinus = {})
}

@Preview(showBackground = true)
@Composable
fun TipRowPreview(
) {
    TipRow(number = 5, onClickPlus = {}, onClickMinus = {})
}
