package com.sipanduberadat.user.utils

import android.content.Context
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.sipanduberadat.user.R

@ColorInt
fun Context.getColorFromAttr(
    @AttrRes attrColor: Int,
    typedValue: TypedValue = TypedValue(),
    resolveRefs: Boolean = true
): Int {
    theme.resolveAttribute(attrColor, typedValue, resolveRefs)
    return typedValue.data
}

fun snackbarSuccess(
    contextView: View,
    message: String,
    length: Int
): Snackbar {
    return Snackbar.make(contextView, message, length).apply {
        setBackgroundTint(ContextCompat.getColor(context, R.color.green))
        setTextColor(ContextCompat.getColor(context, R.color.white))
    }
}

fun snackbarWarning(
    contextView: View,
    message: String,
    length: Int
): Snackbar {
    return Snackbar.make(contextView, message, length).apply {
        setBackgroundTint(ContextCompat.getColor(context, R.color.yellow))
        setTextColor(ContextCompat.getColor(context, R.color.white))
    }
}