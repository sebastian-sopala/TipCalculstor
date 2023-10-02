package com.example.tipcalculator

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                TheApp()
            }
        }
    }
}

@Composable
fun TheApp(
    modifier: Modifier = Modifier.background(Color.Gray)
) {
    val viewModel = viewModel<TipCalculatorViewModel>()
    val state = viewModel.state

    Column(
//        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        EnterBillField(amount = state.billAmount, onClick = { viewModel.onAction(TipCalculatorActions.Clear) }) {
            viewModel.onAction(TipCalculatorActions.Input(it))
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
        modifier = Modifier.padding(4.dp)
    ) {
        OutlinedTextField(
            value = amount.toString(),
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


