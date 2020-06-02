package com.yeuristic.arsenal.pattern_matching

interface PatternMatching {
    fun <T> indexOf(source: List<T>, pattern: List<T>): Int
}