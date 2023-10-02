package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(amount = state.totalPerPerson)
        EnterBillField(
            amount = state.billAmount,
            onClick = { viewModel.onAction(TipCalculatorActions.Clear) }) {
            viewModel.onAction(TipCalculatorActions.Input(it))
        }
        SplitRow(
            number = state.splitBy,
            onClickPlus = { viewModel.onAction(TipCalculatorActions.SplitPlusButtonPress) }) {
            viewModel.onAction(TipCalculatorActions.SplitMinusButtonPress)
        }
        TipRow(
            number = state.tipPercentage,
            onClickPlus = { viewModel.onAction(TipCalculatorActions.TipPlusButtonPress) }) {
            viewModel.onAction(TipCalculatorActions.TipMinusButtonPress)
        }
        Button(symbol = "CALCULATE") {
            viewModel.onAction(TipCalculatorActions.Calculate)
        }
    }
}


