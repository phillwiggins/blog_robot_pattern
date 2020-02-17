package com.purewowstudio.robotpattern

interface MainView {
    data class ViewState(val count: Int)

    sealed class Event {
        object IncrementPressed: Event()
        object DecrementPressed: Event()
    }
}
