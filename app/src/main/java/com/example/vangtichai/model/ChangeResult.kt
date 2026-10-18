package com.example.vangtichai.model

/**
 * Data class representing the calculation result for a single denomination.
 *
 * @property denomination The face value in Taka (e.g. 500, 100, 50, 20, 10, 5, 2, 1).
 * @property count The number of notes or coins required for this denomination.
 * @property subtotal The total monetary amount for this denomination (count * denomination).
 */
data class ChangeItem(
    val denomination: Int,
    val count: Int,
    val subtotal: Long
)

/**
 * Data class encapsulating the full change breakdown calculation.
 *
 * @property totalAmount The total amount entered by the user.
 * @property totalNotesCount Sum of all notes and coins required.
 * @property items Breakdown items for all 8 denominations in descending order.
 */
data class ChangeBreakdown(
    val totalAmount: Long,
    val totalNotesCount: Int,
    val items: List<ChangeItem>
)
