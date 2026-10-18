package com.example.vangtichai.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.vangtichai.model.ChangeBreakdown
import com.example.vangtichai.util.ChangeCalculator

class VangtiChaiViewModel(private val stateHandle: SavedStateHandle) : ViewModel() {

    companion object {
        private const val KEY_AMOUNT_STRING = "key_amount_string"
        private const val DEFAULT_AMOUNT_STRING = "0"
        private const val MAX_INPUT_LENGTH = 9
    }

    private val _amountString = MutableLiveData<String>()
    val amountString: LiveData<String> get() = _amountString

    private val _changeBreakdown = MutableLiveData<ChangeBreakdown>()
    val changeBreakdown: LiveData<ChangeBreakdown> get() = _changeBreakdown

    init {
        val savedAmount = stateHandle.get<String>(KEY_AMOUNT_STRING) ?: DEFAULT_AMOUNT_STRING
        updateAmountString(savedAmount)
    }

    /**
     * Appends a digit ('0'-'9') to the current amount string.
     */
    fun onDigitPressed(digit: Char) {
        if (!digit.isDigit()) return

        val current = _amountString.value ?: DEFAULT_AMOUNT_STRING

        val newString = when {
            current == "0" -> {
                if (digit == '0') "0" else digit.toString()
            }
            current.length >= MAX_INPUT_LENGTH -> current
            else -> current + digit
        }

        updateAmountString(newString)
    }

    /**
     * Resets the entered amount to zero.
     */
    fun onClearPressed() {
        updateAmountString(DEFAULT_AMOUNT_STRING)
    }

    private fun updateAmountString(newAmountStr: String) {
        val sanitized = if (newAmountStr.isBlank()) DEFAULT_AMOUNT_STRING else newAmountStr
        _amountString.value = sanitized
        stateHandle[KEY_AMOUNT_STRING] = sanitized

        val numericAmount = sanitized.toLongOrNull() ?: 0L
        _changeBreakdown.value = ChangeCalculator.calculateBreakdown(numericAmount)
    }
}
