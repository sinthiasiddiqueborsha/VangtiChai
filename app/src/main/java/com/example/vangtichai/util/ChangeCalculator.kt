package com.example.vangtichai.util

import com.example.vangtichai.model.ChangeBreakdown
import com.example.vangtichai.model.ChangeItem
import com.example.vangtichai.model.Denominations

/**
 * Utility class executing the greedy change calculation algorithm.
 */
object ChangeCalculator {

    /**
     * Calculates the breakdown of notes and coins for a given amount in Taka.
     * Uses a greedy approach from largest denomination (৳500) to smallest (৳1).
     *
     * @param amount The non-negative integer amount entered by the user.
     * @return [ChangeBreakdown] containing individual denomination counts, subtotals, and overall totals.
     */
    fun calculateBreakdown(amount: Long): ChangeBreakdown {
        val safeAmount = if (amount < 0) 0L else amount
        var remaining = safeAmount
        val items = ArrayList<ChangeItem>(Denominations.ALL.size)
        var totalNotesCount = 0

        for (denomination in Denominations.ALL) {
            val count = (remaining / denomination).toInt()
            val subtotal = count.toLong() * denomination
            remaining %= denomination

            items.add(ChangeItem(denomination = denomination, count = count, subtotal = subtotal))
            totalNotesCount += count
        }

        return ChangeBreakdown(
            totalAmount = safeAmount,
            totalNotesCount = totalNotesCount,
            items = items
        )
    }
}
