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
            is TipCalculatorActions.TipMinusButtonPress -> {}
            is TipCalculatorActions.Input -> onInput(action.number)
            is TipCalculatorActions.Clear -> state = TipCalculatorState()
        }
    }


    private fun onSplitPlusButtonPress() {
        state = state.copy(splitBy = state.splitBy++)
    }

    private fun onSplitMinusButtonPress() {
        if(state.splitBy < 2) return
        state = state.copy(splitBy = state.splitBy--)
    }

    private fun onTipPlusButtonPress() {
        state = state.copy(tipPercentage = state.tipPercentage + 5)
    }

//    private fun onTipMinusButtonPress() {
//    }


    private fun onInput(amount: String) {
        state = state.copy(billAmount = amount )
    }
}