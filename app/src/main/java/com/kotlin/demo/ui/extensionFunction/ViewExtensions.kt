package com.kotlin.demo.ui.extensionFunction

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.kotlin.demo.R


fun Fragment.displayToast(message:String?){
    Toast.makeText(this.context,message,Toast.LENGTH_SHORT).show()
}

fun Fragment.displaySuccessDialog(message: String){
    this.context?.let {
        MaterialDialog(it)
        .show{
            title(R.string.text_success)
            message(text = message)
            positiveButton(R.string.text_ok)
        }
    }
}

fun Fragment.displayErrorDialog(errorMessage: String){
    this.context?.let {
        MaterialDialog(it)
        .show{
            title(R.string.text_error)
            message(text = errorMessage)
            positiveButton(R.string.text_ok)
        }
    }
}

fun Fragment.areYouSureDialog(message: String, callback: AreYouSureCallback){
    this.context?.let {
        MaterialDialog(it)
        .show{
            title(R.string.are_you_sure)
            message(text = message)
            negativeButton(R.string.text_cancel){
                callback.cancel()
            }
            positiveButton(R.string.text_yes){
                callback.proceed()
            }
        }
    }
}

interface AreYouSureCallback{

    fun proceed()

    fun cancel()
}
