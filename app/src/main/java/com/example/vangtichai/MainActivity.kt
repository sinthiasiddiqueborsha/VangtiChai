package com.example.vangtichai

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.vangtichai.databinding.ActivityMainBinding
import com.example.vangtichai.model.ChangeBreakdown
import com.example.vangtichai.viewmodel.VangtiChaiViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: VangtiChaiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupKeypadListeners()
        observeViewModel()
    }

    private fun setupKeypadListeners() {
        val digitButtons = mapOf(
            binding.btn0 to '0',
            binding.btn1 to '1',
            binding.btn2 to '2',
            binding.btn3 to '3',
            binding.btn4 to '4',
            binding.btn5 to '5',
            binding.btn6 to '6',
            binding.btn7 to '7',
            binding.btn8 to '8',
            binding.btn9 to '9'
        )

        for ((button, char) in digitButtons) {
            button.setOnClickListener {
                viewModel.onDigitPressed(char)
            }
        }

        binding.btnClear.setOnClickListener {
            viewModel.onClearPressed()
        }
    }

    private fun observeViewModel() {
        viewModel.amountString.observe(this) { amountStr ->
            if (amountStr.isEmpty() || amountStr == "0") {
                binding.tvAmountDisplay.text = getString(R.string.taka_empty)
            } else {
                binding.tvAmountDisplay.text = getString(R.string.taka_formatted, amountStr)
            }
        }

        viewModel.changeBreakdown.observe(this) { breakdown ->
            updateChangeBreakdown(breakdown)
        }
    }

    private fun updateChangeBreakdown(breakdown: ChangeBreakdown) {
        val denomViews = mapOf(
            500 to binding.tv500,
            100 to binding.tv100,
            50 to binding.tv50,
            20 to binding.tv20,
            10 to binding.tv10,
            5 to binding.tv5,
            2 to binding.tv2,
            1 to binding.tv1
        )

        for (item in breakdown.items) {
            val tv = denomViews[item.denomination]
            tv?.text = getString(R.string.denom_row_format, item.denomination, item.count)
        }
    }
}
