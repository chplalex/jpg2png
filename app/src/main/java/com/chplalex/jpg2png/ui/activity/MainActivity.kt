package com.chplalex.jpg2png.ui.activity

import android.os.Bundle
import com.chplalex.jpg2png.R
import com.chplalex.jpg2png.mvp.presenter.MainPresenter
import com.chplalex.jpg2png.mvp.view.MainView
import com.chplalex.jpg2png.ui.App
import com.chplalex.jpg2png.ui.BackButtonListener
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(), MainView  {

    private val navigator = SupportAppNavigator(this, supportFragmentManager, R.id.fragmentContainer)
    private val navigatorHolder = App.instance.navigatorHolder
    private val presenter by moxyPresenter { MainPresenter(App.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) return
        }
        presenter.backPressed()
    }
}