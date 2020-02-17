package com.purewowstudio.robotpattern

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class MainActivityTest {

    @get:Rule
    val activityRule =
        ActivityTestRule(MainActivity::class.java)

    private val robot = MainActivityRobot()

    @Before
    fun setup() {
        robot.setup()
    }

    @After
    fun shutdown() {
        robot.shutDown()
    }

    @Test
    fun givenIncrementButtonIsPressedOnceNumberEqualsOne() {
        with(robot) {
            givenTheCurrentValueIsZero()
            whenTheIncrementButtonIsPressed()
            thenVerifyCountIs(1)
        }
    }

    @Test
    fun givenDecrementButtonIsPressedOnceNumberEqualsOne() {
        with(robot) {
            givenTheCurrentValueIsZero()
            whenTheDecrementButtonIsPressed()
            thenVerifyCountIs(-1)
        }
    }

    @Test
    fun givenDecrementButtonIsPressedAndDecrementIsPressedOnceVerifyNumberIsZero() {
        with(robot) {
            givenTheCurrentValueIsZero()
            whenTheDecrementButtonIsPressed()
            whenTheIncrementButtonIsPressed()
            thenVerifyCountIs(0)
        }
    }

    @Test
    fun givenIncrementIsPressedTwentyTimesVerifyCountIsTwenty() {
        val times = 20

        with(robot) {
            givenTheCurrentValueIsZero()
            repeat(times) { whenTheIncrementButtonIsPressed() }
            thenVerifyCountIs(times)
        }
    }
}