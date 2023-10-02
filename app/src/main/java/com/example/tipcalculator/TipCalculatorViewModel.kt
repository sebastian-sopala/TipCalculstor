package com.example.tipcalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class TipCalculatorViewModel : ViewModel() {

    var state by mutableStateOf(TipCalculatorState())
        private set

    fun onAction(action: TipCalculatorActions) {
        when (action) {
            is TipCalculatorActions.SplitPlusButtonPress -> onSplitPlusButtonPress()
            is TipCalculatorActions.SplitMinusButtonPress -> onSplitMinusButtonPress()
            is TipCalculatorActions.TipPlusButtonPress -> onTipPlusButtonPress()
            is TipCalculatorActions.TipMinusButtonPress -> onTipMinusButtonPress()
            is TipCalculatorActions.Input -> onInput(action.number)
            is TipCalculatorActions.Clear -> state = TipCalculatorState()
            is TipCalculatorActions.Calculate -> calculate()
        }
    }

    private fun calculate() {
        val amount = state.billAmount.toFloat()
        val split = state.splitBy
        val tip = state.tipPercentage
        val tipValue = (amount * tip)/100
        val totalPerPerson = ((amount + tipValue) / split).toString()
        state = state.copy(totalPerPerson = totalPerPerson)
    }

    private fun onSplitPlusButtonPress() {
        state = state.copy(splitBy = state.splitBy + 1)
    }

    private fun onSplitMinusButtonPress() {
        if (state.splitBy < 2) return
        state = state.copy(splitBy = state.splitBy - 1)
    }

    private fun onTipPlusButtonPress() {
        state = state.copy(tipPercentage = state.tipPercentage + 5)
    }

    private fun onTipMinusButtonPress() {
        if (state.tipPercentage < 5) return
        state = state.copy(tipPercentage = state.tipPercentage - 5)
    }

    private fun onInput(amount: String) {
        state = state.copy(billAmount = amount)
    }
}