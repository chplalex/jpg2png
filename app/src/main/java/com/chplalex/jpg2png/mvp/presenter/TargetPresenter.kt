package com.chplalex.jpg2png.mvp.presenter

import android.content.Context
import android.net.Uri
import com.chplalex.jpg2png.common.getFileNameFromUri
import com.chplalex.jpg2png.mvp.view.TargetView
import com.chplalex.jpg2png.ui.BackButtonListener
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class TargetPresenter(
    private val context: Context,
    private val router: Router,
    private val uri: Uri
) : MvpPresenter<TargetView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setImage(uri)
        getFileNameFromUri(context, uri)?.let { viewState.setText(it) }
    }

    fun backClick() : Boolean {
        router.exit()
        return true
    }
}