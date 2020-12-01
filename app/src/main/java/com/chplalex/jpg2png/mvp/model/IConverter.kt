package com.chplalex.jpg2png.mvp.model

import android.net.Uri
import io.reactivex.rxjava3.core.Completable

interface IConverter {
    fun convert(): Completable
    fun getSourceUri(): Uri
    fun getTargetUri(): Uri
    fun getSourceName(): String
    fun getTargetName(): String
}