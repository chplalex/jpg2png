package com.chplalex.jpg2png.common

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.OpenableColumns


const val TAG = "J2P"

@SuppressLint("Recycle")
fun getFileNameFromUri(context: Context, uri: Uri?): String? {
    if (uri == null) return null

    val cursor: Cursor? = context.contentResolver.query(
        uri, null, null, null, null, null)

    var path: String? = null
    cursor?.apply {
        if (moveToFirst()) {
            path = getString(getColumnIndex(OpenableColumns.DISPLAY_NAME))
        }
    }
    return path
}