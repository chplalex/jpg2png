package com.chplalex.jpg2png.navigation

import android.net.Uri
import androidx.fragment.app.Fragment
import com.chplalex.jpg2png.ui.fragment.SourceFragment
import com.chplalex.jpg2png.ui.fragment.TargetFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class SourceScreen: SupportAppScreen() {
        override fun getFragment(): Fragment = SourceFragment.newInstance()
    }
    class TargetScreen(private val uri: Uri): SupportAppScreen() {
        override fun getFragment(): Fragment = TargetFragment.newInstance(uri)
    }
}