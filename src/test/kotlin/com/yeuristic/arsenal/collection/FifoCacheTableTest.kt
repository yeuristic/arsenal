package com.yeuristic.arsenal.collection

import org.junit.Assert
import org.junit.Test
import java.lang.IndexOutOfBoundsException

class FifoCacheTableTest {
    @Test
    fun `add to max size 2 x 3`() {
        //Arrange
        val fifoCacheTable = FifoCacheTable<Int>(2, 3)

        //Act
        for (i in 0 until fifoCacheTable.row * fifoCacheTable.column) {
            fifoCacheTable.add(i)
        }

        //Assert
        var idx = 0
        for (i in 0 until fifoCacheTable.row) {
            for (j in 0 until fifoCacheTable.column) {
                Assert.assertEquals(idx++, fifoCacheTable.get(j, i))
            }
        }
    }

    @Test
    fun `1 before max size 2 x 3`() {
        //Arrange
        val fifoCacheTable = FifoCacheTable<Int>(2, 3)

        //Act
        for (i in 0 until fifoCacheTable.row * fifoCacheTable.column - 1) {
            fifoCacheTable.add(i)
        }

        //Assert
        var idx = 0
        val iterator = fifoCacheTable.iterator()
        while (iterator.hasNext()) {
            Assert.assertEquals(idx++, iterator.next())
        }
    }

    @Test
    fun `1 after max size 2 x 3`() {
        //Arrange
        val fifoCacheTable = FifoCacheTable<Int>(2, 3)

        //Act
        for (i in 0 until fifoCacheTable.row * fifoCacheTable.column + 1) {
            fifoCacheTable.add(i)
        }

        //Assert
        Assert.assertNull(fifoCacheTable.get(0,0))
        Assert.assertEquals(1, fifoCacheTable.get(1,0))

        var idx = 1
        val iterator = fifoCacheTable.iterator()
        while (iterator.hasNext()) {
            Assert.assertEquals(idx++, iterator.next())
        }
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun `exception when access beyond index`() {
        //Arrange
        val fifoCacheTable = FifoCacheTable<Int>(2, 3)

        //Act
        fifoCacheTable.get(0,0)
    }
}