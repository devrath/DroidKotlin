package com.kotlin.demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.demo.databinding.FragmentDemoKotlinCompanionObjectBinding
import com.kotlin.demo.ui.CompanionObject.Companion.incrementValue
import com.kotlin.demo.ui.CompanionObject.Companion.printValue

class DemoKotlinCompanionObject: Fragment() {

    companion object classe{
        var initialVal = 50
    }

    private var _binding: FragmentDemoKotlinCompanionObjectBinding? = null
    private val binding get() = _binding!!

    private val TAG: String = "CompanionObject"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDemoKotlinCompanionObjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("Demo value when class loaded is: $initialVal")
        binding.fabNew.setOnClickListener {
            incrementValue()
        }
        binding.fabAdd.setOnClickListener {
            printValue()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init() {

    }
}

class CompanionObject{

    companion object {
        var  demoVal = 0
        fun incrementValue() { demoVal++ }
        fun printValue() { println("Current value is: $demoVal")}
    }

}