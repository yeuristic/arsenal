package com.yeuristic.arsenal.collection

import java.lang.IllegalArgumentException
import kotlin.math.max
import kotlin.math.min

class FifoCacheTable<T>(val column: Int, val row: Int) : Collection<T> {

    private var count = 0
    private val array: ArrayList<ArrayList<T>>

    init {
        Math.multiplyExact(column, row)
        if (column * row <= 0) {
            throw IllegalArgumentException("Cache size can't be empty")
        }
        array = ArrayList(
            row
        )
    }

    private fun maxCount() = column * row

    //Return true if this addition replace old element
    fun add(element: T): Boolean {
        val targetCol = count % column
        val targetRow = count / column
        val mappedRow = targetRow % row

        count++
        if (mappedRow !in array.indices) {
            array.add(ArrayList(column))
        }
        if (targetCol in array[mappedRow].indices) {
            array[mappedRow][targetCol] = element
            return true
        } else {
            array[mappedRow].add(element)
            return false
        }
    }

    fun get(column: Int, row: Int): T? {
        val cellValue = this.column * row + column
        //if cell replaced
        if (count - maxCount() > cellValue) {
            return null
        }

        val mappedRow = row % this.row
        return array[mappedRow][column]
    }

    override val size: Int
        get() = min(count, maxCount())

    override fun contains(element: T): Boolean {
        array.forEach {
            it.forEach {
                if (it == element) {
                    return true
                }
            }
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        //TODO improve algorithm
        elements.forEach {
            if (!contains(it)) {
                return false
            }
        }
        return true
    }

    override fun isEmpty(): Boolean = count == 0

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            var index = max(0, count - maxCount())
            override fun hasNext(): Boolean = index < count

            override fun next(): T {
                val targetCol = index % column
                val targetRow = index / column
                val mappedRow = targetRow % row
                index++
                return array[mappedRow][targetCol]
            }

        }
    }
}