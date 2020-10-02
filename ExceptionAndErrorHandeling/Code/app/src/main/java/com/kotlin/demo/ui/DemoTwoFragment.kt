package com.kotlin.demo.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.demo.databinding.FragmentDemoTwoBinding
import kotlinx.coroutines.*

class DemoTwoFragment : Fragment() {

    private var _binding: FragmentDemoTwoBinding? = null
    private val binding get() = _binding!!

    private val JOB_ONE_TIME : Long = 1000L
    private val JOB_TWO_TIME : Long = 3000L

    private val TAG: String = "ExceptionDemo"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDemoTwoBinding.inflate(inflater, container, false)
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

    val exception = CoroutineExceptionHandler { _, exception ->
        println("Exception thrown in one of the children: ${exception.message}")
    }

    private fun init() {

        Log.d(TAG,"Before parent Co routine")

        val parentJob = CoroutineScope(Dispatchers.IO).launch(exception){
            val job1 : Job = launch {
                delay(JOB_ONE_TIME)
                throw Exception("User threw a exception")
            }

            val job2 : Job = launch { delay(JOB_TWO_TIME) }

            job1.invokeOnCompletion { throwable ->
                if(throwable!=null)
                    Log.d(TAG,"Error getting Job-1: ${throwable.message}")
                else
                    Log.d(TAG,"Job-1 is Success")
            }

            job2.invokeOnCompletion { throwable ->
                if(throwable!=null)
                    Log.d(TAG,"Error getting Job-2: ${throwable.message}")
                else
                    Log.d(TAG,"Job-2 is Success")
            }
        }

        Log.d(TAG,"After parent Co routine")

        parentJob.invokeOnCompletion { throwable ->
            if(throwable != null)
                Log.d(TAG,"Parent job failed: ${throwable.message}")
            else
                Log.d(TAG,"Parent job is Success")
        }
    }
}