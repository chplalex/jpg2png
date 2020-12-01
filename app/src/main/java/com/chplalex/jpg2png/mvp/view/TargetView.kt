package com.chplalex.jpg2png.mvp.view

import android.net.Uri
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle

@StateStrategyType(AddToEndSingleStrategy::class)
interface TargetView : MvpView {
    fun setImage(data: Uri)
    fun setText(data: String)
}