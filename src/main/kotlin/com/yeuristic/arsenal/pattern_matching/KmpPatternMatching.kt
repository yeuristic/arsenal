package com.yeuristic.arsenal.pattern_matching

object KmpPatternMatching : PatternMatching {
    override fun <T> indexOf(source: List<T>, pattern: List<T>): Int {
        val lpsTable: IntArray = buildTable(pattern)
        var index = 0
        var tableIdx = 0
        while (index in source.indices && tableIdx in pattern.indices) {
            if (source[index] == pattern[tableIdx]) {
                index++
                tableIdx++
            } else {
                if (tableIdx == 0) {
                    index++
                } else {
                    tableIdx = lpsTable[tableIdx - 1]
                }
            }
        }
        return if (tableIdx >= pattern.size) {
            index - pattern.size
        } else {
            -1
        }
    }

    private fun <T> buildTable(pattern: List<T>): IntArray =
        IntArray(pattern.count()).also {
            var prefixIdx = 0
            for (index in 1 until pattern.size) {
                if (pattern[index] == pattern[prefixIdx]) {
                    it[index] = ++prefixIdx
                } else {
                    prefixIdx = 0
                }
            }
        }

}