package com.example.vangtichai

import com.example.vangtichai.util.ChangeCalculator
import org.junit.Assert.assertEquals
import org.junit.Test

class ChangeCalculatorTest {

    @Test
    fun testAmountZero() {
        val breakdown = ChangeCalculator.calculateBreakdown(0L)
        assertEquals(0L, breakdown.totalAmount)
        assertEquals(0, breakdown.totalNotesCount)
        assertEquals(8, breakdown.items.size)

        for (item in breakdown.items) {
            assertEquals(0, item.count)
            assertEquals(0L, item.subtotal)
        }
    }

    @Test
    fun testAmountOne() {
        val breakdown = ChangeCalculator.calculateBreakdown(1L)
        assertEquals(1L, breakdown.totalAmount)
        assertEquals(1, breakdown.totalNotesCount)

        val item1 = breakdown.items.first { it.denomination == 1 }
        assertEquals(1, item1.count)
        assertEquals(1L, item1.subtotal)
    }

    @Test
    fun testAmountTwo() {
        val breakdown = ChangeCalculator.calculateBreakdown(2L)
        assertEquals(2L, breakdown.totalAmount)
        assertEquals(1, breakdown.totalNotesCount)

        val item2 = breakdown.items.first { it.denomination == 2 }
        assertEquals(1, item2.count)
        assertEquals(2L, item2.subtotal)
    }

    @Test
    fun testAmountFive() {
        val breakdown = ChangeCalculator.calculateBreakdown(5L)
        assertEquals(5L, breakdown.totalAmount)
        assertEquals(1, breakdown.totalNotesCount)

        val item5 = breakdown.items.first { it.denomination == 5 }
        assertEquals(1, item5.count)
        assertEquals(5L, item5.subtotal)
    }

    @Test
    fun testAmount786_PDF_Example() {
        // PDF Example: Amount 786
        // 500: 1 (500)
        // 100: 2 (200)
        // 50: 1 (50)
        // 20: 1 (20)
        // 10: 1 (10)
        // 5: 1 (5)
        // 2: 0 (0)
        // 1: 1 (1)
        // Total: 8 notes, Total ৳786
        val breakdown = ChangeCalculator.calculateBreakdown(786L)

        assertEquals(786L, breakdown.totalAmount)
        assertEquals(8, breakdown.totalNotesCount)

        val expectedCounts = mapOf(
            500 to 1,
            100 to 2,
            50 to 1,
            20 to 1,
            10 to 1,
            5 to 1,
            2 to 0,
            1 to 1
        )

        for (item in breakdown.items) {
            val expectedCount = expectedCounts[item.denomination] ?: 0
            assertEquals("Mismatch count for ৳${item.denomination}", expectedCount, item.count)
            assertEquals("Mismatch subtotal for ৳${item.denomination}", (expectedCount * item.denomination).toLong(), item.subtotal)
        }

        val sumSubtotals = breakdown.items.sumOf { it.subtotal }
        assertEquals(786L, sumSubtotals)
    }

    @Test
    fun testAmount1000() {
        val breakdown = ChangeCalculator.calculateBreakdown(1000L)
        assertEquals(1000L, breakdown.totalAmount)
        assertEquals(2, breakdown.totalNotesCount)

        val item500 = breakdown.items.first { it.denomination == 500 }
        assertEquals(2, item500.count)
        assertEquals(1000L, item500.subtotal)
    }

    @Test
    fun testAmount9999() {
        val breakdown = ChangeCalculator.calculateBreakdown(9999L)
        assertEquals(9999L, breakdown.totalAmount)

        // 9999 = 19x500 (9500) + 4x100 (400) + 1x99 -> 1x50 (50) + 2x20 (40) + 0x10 + 1x5 (5) + 2x2 (4) = 9999
        val sumSubtotals = breakdown.items.sumOf { it.subtotal }
        assertEquals(9999L, sumSubtotals)
    }

    @Test
    fun testLargeAmount() {
        val largeAmount = 999999999L
        val breakdown = ChangeCalculator.calculateBreakdown(largeAmount)
        assertEquals(largeAmount, breakdown.totalAmount)

        val sumSubtotals = breakdown.items.sumOf { it.subtotal }
        assertEquals(largeAmount, sumSubtotals)
    }
}
