package com.rknrnmmt.androisplashtest.ui.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rknrnmmt.androisplashtest.R


class SplashFragment : Fragment() {


    private val SPLASH_SCREEN_MILLIS = 1000L
    // we will show our splash screen before the app opens using a handler
    private val handlerSplash = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Opens the MainFragment after a second
        handlerSplash.postDelayed({
            val action = SplashFragmentDirections.actionSplashFragmentToMainFragment()
            findNavController().navigate(action)
        },
            SPLASH_SCREEN_MILLIS)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        handlerSplash.removeCallbacksAndMessages(null)
    }

}