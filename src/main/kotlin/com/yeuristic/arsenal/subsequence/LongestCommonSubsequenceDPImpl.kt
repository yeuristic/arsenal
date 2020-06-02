package com.yeuristic.arsenal.subsequence

import com.yeuristic.arsenal.collection.FifoCacheTable
import kotlin.math.max

object LongestCommonSubsequenceDPImpl : LongestCommonSubsequence {
    override fun <T> longestCommonSubsequenceOf(firstSequence: List<T>, secondSequence: List<T>): Int {
        if (firstSequence.isEmpty() || secondSequence.isEmpty()) {
            return 0
        }
        val fifoCacheTable = FifoCacheTable<Int>(firstSequence.size, 2)
        for (row in secondSequence.indices) {
            for (col in firstSequence.indices) {
                if (firstSequence[col] == secondSequence[row]) {
                    fifoCacheTable.add(1 + getValue(fifoCacheTable, col - 1, row - 1))
                } else {
                    val left = getValue(fifoCacheTable, col - 1, row)
                    val top = getValue(fifoCacheTable, col, row - 1)
                    fifoCacheTable.add(max(left, top))
                }
            }
        }
        return fifoCacheTable.get(firstSequence.size - 1, secondSequence.size - 1) ?: 0
    }

    private fun getValue(fifoCacheTable: FifoCacheTable<Int>, col: Int, row: Int): Int {
        return if (col < 0 || row < 0) {
            0
        } else {
            fifoCacheTable.get(col, row) ?: 0
        }
    }
}