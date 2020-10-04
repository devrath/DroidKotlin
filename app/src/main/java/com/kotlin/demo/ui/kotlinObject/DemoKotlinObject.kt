package com.kotlin.demo.ui.kotlinObject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.demo.databinding.FragmentDemoKotlinObjectBinding

class DemoKotlinObject : Fragment() {

    private var _binding: FragmentDemoKotlinObjectBinding? = null
    private val binding get() = _binding!!

    private val TAG: String = "KotlinObject"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDemoKotlinObjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            init()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init() {
        Singleton.printVarName()
    }
}

object Singleton {

    init {
        val count = 0
        println("Value of counter: $count")
    }

    private var count = 0

    fun printVarName(){
        count++
        println("Value of counter: $count")
    }

}