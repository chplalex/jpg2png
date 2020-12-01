package com.chplalex.jpg2png.mvp.presenter

import android.net.Uri
import com.chplalex.jpg2png.mvp.view.TargetView
import com.chplalex.jpg2png.ui.App
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class TargetPresenter(
    private val router: Router,
    private val uri: Uri,
    private val name: String
) : MvpPresenter<TargetView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setImage(uri)
        viewState.setText(name)
    }

    fun backPressed() : Boolean {
        router.exit()
        return true
    }
}