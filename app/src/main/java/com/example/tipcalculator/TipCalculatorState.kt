package com.example.tipcalculator

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class TipCalculatorState(
//    var billAmount: MutableState<Int> = mutableStateOf(0),
    var billAmount: String = "",
    var splitBy: Int = 1,
    var tipPercentage: Int = 0
)
