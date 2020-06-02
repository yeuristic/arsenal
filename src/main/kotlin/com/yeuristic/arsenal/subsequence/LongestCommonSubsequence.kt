package com.yeuristic.arsenal.subsequence

interface LongestCommonSubsequence {
    fun <T> longestCommonSubsequenceOf(firstSequence: List<T>, secondSequence: List<T>): Int
}