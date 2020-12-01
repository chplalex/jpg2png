package com.chplalex.jpg2png.mvp.presenter

import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.chplalex.jpg2png.common.getFileNameFromUri
import com.chplalex.jpg2png.mvp.view.SourceView
import com.chplalex.jpg2png.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class SourcePresenter(
    private val context: Context,
    private val router: Router
) : MvpPresenter<SourceView>() {

    private var uri: Uri? = null

    fun btnClicked() {
        convertJpg2Png()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun setData(uri: Uri) {
        this.uri = uri
        viewState.setImage(uri)
        getFileNameFromUri(context, uri)?.let { viewState.setText(it) }
    }

    private fun convertJpg2Png() {
        if (uri == null) return

        Toast.makeText(context, "Конвертируем!", Toast.LENGTH_SHORT).show()

        // здесь будет код конвертации
        // пока выводим в Target исходное изображение
        val targetUri: Uri = uri!!
        router.navigateTo(Screens.TargetScreen(targetUri))
    }

    fun backClicked(): Boolean {
        router.exit()
        return true
    }

}