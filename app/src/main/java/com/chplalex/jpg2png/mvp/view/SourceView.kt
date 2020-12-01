package com.chplalex.jpg2png.mvp.view

import android.net.Uri
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface SourceView : MvpView {
    fun init()
    fun setImage(data: Uri)
    fun setText(data: String)
}