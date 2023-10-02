package com.example.tipcalculator

sealed class TipCalculatorActions {

    object SplitPlusButtonPress : TipCalculatorActions()
    object SplitMinusButtonPress : TipCalculatorActions()
    object TipPlusButtonPress : TipCalculatorActions()
    object TipMinusButtonPress : TipCalculatorActions()
    object Clear : TipCalculatorActions()
    data class Input(val number: String) : TipCalculatorActions()
    object Calculate : TipCalculatorActions()

}

