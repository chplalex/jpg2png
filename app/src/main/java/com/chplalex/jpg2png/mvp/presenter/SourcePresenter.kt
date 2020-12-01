package com.chplalex.jpg2png.mvp.presenter

import com.chplalex.jpg2png.mvp.view.SourceView
import com.chplalex.jpg2png.navigation.Screens
import com.chplalex.jpg2png.ui.converter.ImageConverter
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class SourcePresenter(
    private val scheduler: Scheduler,
    private val router: Router
) : MvpPresenter<SourceView>() {

    private var imageConverter: ImageConverter? = null
    private var disposable: Disposable? = null

    fun btnClicked() {
        convertJpg2Png()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun setData(imageConverter: ImageConverter) {
        this.imageConverter = imageConverter
        viewState.setImage(imageConverter.getSourceUri())
        viewState.setText(imageConverter.getSourceName())
    }

    private fun convertJpg2Png() = imageConverter?.let {
        viewState.showProgress()
        disposable = it.convert()
            .observeOn(scheduler)
            .subscribe({
                viewState.hideProgress()
                viewState.showSuccess()
                router.navigateTo(Screens.TargetScreen(it.getTargetUri(), it.getTargetName()))
            }, {
                viewState.hideProgress()
                viewState.showError()
            })
    }

    fun cancelPressed() {
        disposable?.dispose()
        viewState.hideProgress()
        viewState.showCancel()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}