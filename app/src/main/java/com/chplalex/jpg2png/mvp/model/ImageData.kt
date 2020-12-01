package com.chplalex.jpg2png.mvp.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ImageData (val uri: Uri) : Parcelable