package com.dicoding.practice.myidlingresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            delayOne()
            delayTwo()
        }

    }

    private fun delayOne() {
        EspressoIdlingResource.increment()
        Handler().postDelayed({
            text_view.text = getString(R.string.delay1)
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                // Tell the espresso that the job is finished
                EspressoIdlingResource.decrement()
            }
        }, 2000)
    }

    private fun delayTwo() {
        EspressoIdlingResource.increment()
        Handler().postDelayed({
            text_view.text = getString(R.string.delay2)
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                EspressoIdlingResource.decrement()
            }
        }, 3000)
    }
}