package com.chplalex.jpg2png.mvp.presenter

import com.chplalex.jpg2png.mvp.view.MainView
import com.chplalex.jpg2png.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.SourceScreen())
    }

    fun backPressed() {
        router.exit()
    }
}