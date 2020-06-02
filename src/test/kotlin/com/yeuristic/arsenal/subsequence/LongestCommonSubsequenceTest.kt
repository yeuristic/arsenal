package com.yeuristic.arsenal.subsequence

import org.junit.Assert
import org.junit.Test

class LongestCommonSubsequenceTest {
    @Test
    fun `happy path`() {
        //Arrange
        val first = "stone".toList()
        val second = "longest".toList()
        val longestCommonSubsequence = LongestCommonSubsequenceDPImpl

        //Act
        val result = longestCommonSubsequence.longestCommonSubsequenceOf(first, second)

        //Assert
        Assert.assertEquals(3, result)
    }

    @Test
    fun `empty`() {
        //Arrange
        val first = "".toList()
        val second = "".toList()
        val longestCommonSubsequence = LongestCommonSubsequenceDPImpl

        //Act
        val result = longestCommonSubsequence.longestCommonSubsequenceOf(first, second)

        //Assert
        Assert.assertEquals(0, result)
    }

    @Test
    fun `first empty`() {
        //Arrange
        val first = "".toList()
        val second = "longest".toList()
        val longestCommonSubsequence = LongestCommonSubsequenceDPImpl

        //Act
        val result = longestCommonSubsequence.longestCommonSubsequenceOf(first, second)

        //Assert
        Assert.assertEquals(0, result)
    }

    @Test
    fun `second empty`() {
        //Arrange
        val first = "stone".toList()
        val second = "".toList()
        val longestCommonSubsequence = LongestCommonSubsequenceDPImpl

        //Act
        val result = longestCommonSubsequence.longestCommonSubsequenceOf(first, second)

        //Assert
        Assert.assertEquals(0, result)
    }
}