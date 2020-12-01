package com.chplalex.jpg2png.navigation

import android.net.Uri
import com.chplalex.jpg2png.ui.fragment.SourceFragment
import com.chplalex.jpg2png.ui.fragment.TargetFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class SourceScreen: SupportAppScreen() {
        override fun getFragment() = SourceFragment.newInstance()
    }
    class TargetScreen(private val uri: Uri, private val name: String): SupportAppScreen() {
        override fun getFragment() = TargetFragment.newInstance(uri, name)
    }
}