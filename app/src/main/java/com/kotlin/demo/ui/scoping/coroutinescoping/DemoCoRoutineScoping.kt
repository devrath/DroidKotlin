package com.kotlin.demo.ui.scoping.coroutinescoping

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.demo.databinding.FragmentDemoCoroutineScopeBinding
import kotlinx.coroutines.*

class DemoCoRoutineScoping : Fragment() {

    private var _binding: FragmentDemoCoroutineScopeBinding? = null
    private val binding get() = _binding!!

    private val TAG: String = "DemoCoRoutineScoping"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDemoCoroutineScopeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.fab.setOnClickListener {
            Log.d(TAG,"Before run blocking co-routine Scope")
            runBlocking {
                delay(1000L)
                Log.d(TAG,"Inside runBlocking Scope")
                Log.d(TAG,"Before first Scope")
                coroutineScope {
                    delay(2000L)
                    Log.d(TAG,"Inside first Scope")
                }
                Log.d(TAG,"Outside first Scope")
                Log.d(TAG,"Before second Scope")
                coroutineScope {
                    delay(3000L)
                    Log.d(TAG,"Inside second Scope")
                }
                Log.d(TAG,"After second Scope")
                delay(1000L)
            }
            Log.d(TAG,"After run blocking co-routine Scope")
        }
    }

}