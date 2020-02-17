package com.purewowstudio.robotpattern

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.purewowstudio.robotpattern.MainView.Event
import com.purewowstudio.robotpattern.MainView.Event.DecrementPressed
import com.purewowstudio.robotpattern.MainView.Event.IncrementPressed
import com.purewowstudio.robotpattern.MainView.ViewState

class MainViewModel : ViewModel() {

    private val viewState: MutableLiveData<ViewState> = MutableLiveData()

    fun getViewState(): LiveData<ViewState> = viewState

    init {
        updateViewState(ViewState(0))
    }

    fun onEvent(event: Event) {
        when (event) {
            is IncrementPressed -> incrementCount()
            is DecrementPressed -> decrementCount()
        }
    }

    private fun updateViewState(state: ViewState) {
        viewState.value = state
    }

    private fun incrementCount() {
        viewState.value?.let {
            updateViewState(it.copy(count = it.count + 1))
        }
    }

    private fun decrementCount() {
        viewState.value?.let {
            updateViewState(it.copy(count = it.count - 1))
        }
    }
}