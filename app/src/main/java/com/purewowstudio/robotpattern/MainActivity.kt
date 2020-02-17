package com.purewowstudio.robotpattern

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.purewowstudio.robotpattern.MainView.Event.DecrementPressed
import com.purewowstudio.robotpattern.MainView.Event.IncrementPressed
import com.purewowstudio.robotpattern.MainView.ViewState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUI()
        observeViewModel()
        addEventListeners()
    }

    private fun setUI() {
        setContentView(R.layout.activity_main)
    }

    private fun observeViewModel() {
        viewModel.getViewState().observe(this, ::updateUI)
    }

    private fun updateUI(viewState: ViewState) {
        textCount.text = "${viewState.count}"
    }

    private fun addEventListeners() {
        buttonIncrement.setOnClickListener {
            viewModel.onEvent(IncrementPressed)
        }

        buttonDecrement.setOnClickListener {
            viewModel.onEvent(DecrementPressed)
        }
    }
}