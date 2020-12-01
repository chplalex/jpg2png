package com.chplalex.jpg2png.mvp.view

import android.net.Uri
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@StateStrategyType(AddToEndSingleStrategy::class)
interface SourceView : MvpView {
    fun init()

    fun setImage(data: Uri)
    fun setText(data: String)

    fun showProgress()
    fun hideProgress()

    @OneExecution
    fun showSuccess()
    @OneExecution
    fun showError()
    @OneExecution
    fun showCancel()

}