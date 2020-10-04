package com.kotlin.demo.ui.higherOrderFunction

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.demo.databinding.FragmentDemoExtensionFunctionBinding
import com.kotlin.demo.databinding.FragmentDemoHigherOrderFunctionBinding
import com.kotlin.demo.ui.companionObject.CompanionObject

class DemoHigherOrderFunction : Fragment() {

    private var _binding: FragmentDemoHigherOrderFunctionBinding? = null
    private val binding get() = _binding!!

    private val TAG: String = "HigherOrderFunction"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDemoHigherOrderFunctionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.fabAdd.setOnClickListener {
            higherOrderFunction("Second String",::printFunc)
        }
    }

    private fun higherOrderFunction(initialString : String, finalString : (String) -> Unit) {
        Log.d(TAG,"First String")
        printFunc("Second String")
    }

    fun printFunc(str : String){
        Log.d(TAG,str)
    }

}