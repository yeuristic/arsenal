package com.yeuristic.arsenal.pattern_matching

import org.junit.Assert
import org.junit.Test

class KmpTest {
    @Test
    fun `happy path`() {
        //Arrange
        val source = "ababcabcabababd"
        val pattern = "ababd"
        val kmpPatternMatching = KmpPatternMatching

        //Act
        val indexOf = kmpPatternMatching.indexOf(source.toList(), pattern.toList())

        //Assert
        Assert.assertEquals(10, indexOf)
    }

    @Test
    fun `instantly found`() {
        //Arrange
        val source = "ababdabcabababz"
        val pattern = "ababd"
        val kmpPatternMatching = KmpPatternMatching

        //Act
        val indexOf = kmpPatternMatching.indexOf(source.toList(), pattern.toList())

        //Assert
        Assert.assertEquals(0, indexOf)
    }

    @Test
    fun `empty pattern`() {
        //Arrange
        val source = "ababdabcabababz"
        val kmpPatternMatching = KmpPatternMatching

        //Act
        val indexOf = kmpPatternMatching.indexOf(source.toList(), emptyList())

        //Assert
        Assert.assertEquals(0, indexOf)
    }

    @Test
    fun `not found`() {
        //Arrange
        val source = "ababcabcabababz"
        val pattern = "ababd"
        val kmpPatternMatching = KmpPatternMatching

        //Act
        val indexOf = kmpPatternMatching.indexOf(source.toList(), pattern.toList())

        //Assert
        Assert.assertEquals(-1, indexOf)
    }
}