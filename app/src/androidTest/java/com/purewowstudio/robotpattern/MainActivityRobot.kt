package com.purewowstudio.robotpattern

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

class MainActivityRobot {

    fun setup() {
        // NO OP
    }

    fun shutDown() {
        // NO OP
    }

    fun givenTheCurrentValueIsZero() {
        // NO OP - Default is Zero
    }

    fun whenTheIncrementButtonIsPressed() {
        onView(withId(R.id.buttonIncrement)).perform(click())
    }

    fun whenTheDecrementButtonIsPressed() {
        onView(withId(R.id.buttonDecrement)).perform(click())
    }

    fun thenVerifyCountIs(amount: Int) {
        onView(withId(R.id.textCount)).check(matches(withText(amount.toString())))
    }
}
