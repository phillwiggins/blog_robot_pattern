package com.purewowstudio.robotpattern

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    private val robot = MainViewModelRobot()

    @Suppress("unused")
    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        robot.setup()
    }

    @After
    fun shutdown() {
        robot.shutDown()
    }

    @Test
    fun `when increment is pressed, count should be 1`() {
        with(robot) {
            givenTheCurrentValueIsZero()
            whenTheIncrementButtonIsPressed()
            thenVerifyCountIs(1)
        }
    }

    @Test
    fun `when decrement button is pressed, count should be -1`() {
        with(robot) {
            givenTheCurrentValueIsZero()
            whenTheDecrementButtonIsPressed()
            thenVerifyCountIs(-1)
        }
    }

    @Test
    fun `when increment then decrement is pressed, count should be 0`() {
        with(robot) {
            givenTheCurrentValueIsZero()
            whenTheDecrementButtonIsPressed()
            whenTheIncrementButtonIsPressed()
            thenVerifyCountIs(0)
        }
    }

    @Test
    fun `given increment is pressed twenty times, count should be 20`() {
        val times = 20

        with(robot) {
            givenTheCurrentValueIsZero()
            repeat(times) { whenTheIncrementButtonIsPressed() }
            thenVerifyCountIs(times)
        }
    }
}