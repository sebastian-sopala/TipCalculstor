package com.example.tipcalculator

data class TipCalculatorState(
    var billAmount: String = "",
    var splitBy: Int = 1,
    var tipPercentage: Int = 0,
    var totalPerPerson: String = "0",
)
