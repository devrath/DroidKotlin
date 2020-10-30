package com.kotlin.demo.ui.scoping.globalScoping

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.demo.databinding.FragmentDemoGlobalScopeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DemoGlobalScoping : Fragment() {

    private var _binding: FragmentDemoGlobalScopeBinding? = null
    private val binding get() = _binding!!

    private val TAG: String = "DemoGlobalScoping"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDemoGlobalScopeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.fab.setOnClickListener {
            Log.d(TAG,"Before starting Global Scope")
            GlobalScope.launch {
                delay(1000L)
                Log.d(TAG,"Inside Global Scope")
            }
            Log.d(TAG,"After completing Global Scope")
        }
    }
}