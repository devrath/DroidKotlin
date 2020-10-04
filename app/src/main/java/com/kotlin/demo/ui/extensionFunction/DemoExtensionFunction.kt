package com.kotlin.demo.ui.extensionFunction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.kotlin.demo.R
import com.kotlin.demo.databinding.FragmentDemoExtensionFunctionBinding
import com.kotlin.demo.databinding.FragmentDemoJobExceptionHandlingBinding

class DemoExtensionFunction  : Fragment() {

    private var _binding: FragmentDemoExtensionFunctionBinding? = null
    private val binding get() = _binding!!

    private val TAG: String = "ExtensionFunction"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDemoExtensionFunctionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.successToast.setToastMessageListener(getString(R.string.message_one))
        binding.errorToast.setToastMessageListener(getString(R.string.message_error))
        binding.successDialog.setDialogMessageListener(getString(R.string.message_succes), false)
        binding.errorDialog.setDialogMessageListener(getString(R.string.message_error), true)

        binding.areYouSure.setOnClickListener {
            val areYouSureCallback = object: AreYouSureCallback{
                override fun proceed() {
                    displayToast(getString(R.string.message_one))
                }

                override fun cancel() {
                    displayToast(getString(R.string.message_cancelled))
                }
            }
            areYouSureDialog(getString(R.string.message_are_you_sure), areYouSureCallback)
        }
    }

    private fun Button.setToastMessageListener(message: String?){
        this.setOnClickListener {
            message?.let { displayToast(message) }
        }
    }

    private fun Button.setDialogMessageListener(message: String, isError: Boolean){
        this.setOnClickListener {
            if(isError) displayErrorDialog(message)
            else displaySuccessDialog(message)
        }
    }

}