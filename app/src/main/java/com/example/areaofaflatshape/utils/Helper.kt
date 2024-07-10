package com.example.areaofaflatshape.utils

import android.app.Activity
import android.widget.EditText
import android.widget.Toast

object Helper {

    fun Activity.showShortToast(text: String?) {
        // Use ? for null safe. the code will not execute code inside curly brace, if text == null
        text?.let {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }

    fun Activity.showLongToast(text: String?) {
        // Use ? for null safe. the code will not execute code inside curly brace, if text == null
        text?.let {
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }
    }

    fun showError(editText: EditText?) {
        editText?.error = "Form Tidak Boleh Kosong"
    }

    fun isValidEditTextForm(editText: EditText?): Boolean {
        return !editText?.text.isNullOrBlank()
    }

}