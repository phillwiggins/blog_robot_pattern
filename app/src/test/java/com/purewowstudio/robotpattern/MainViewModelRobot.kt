package com.purewowstudio.robotpattern

import androidx.lifecycle.Observer
import com.purewowstudio.robotpattern.MainView.Event.DecrementPressed
import com.purewowstudio.robotpattern.MainView.Event.IncrementPressed
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertNotNull

class MainViewModelRobot {

    private lateinit var viewModel: MainViewModel

    @MockK
    private lateinit var observer: Observer<MainView.ViewState>

    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
        viewModel = MainViewModel()
        viewModel.getViewState().observeForever(observer)
    }

    fun shutDown() {
        viewModel.getViewState().removeObserver(observer)
    }

    fun givenTheCurrentValueIsZero() {
        // NO OP - Default is Zero
    }

    fun whenTheIncrementButtonIsPressed() {
        viewModel.onEvent(IncrementPressed)
    }

    fun whenTheDecrementButtonIsPressed() {
        viewModel.onEvent(DecrementPressed)
    }

    fun thenVerifyCountIs(amount: Int) {
        assertNotNull(viewModel.getViewState().value)
    }
}