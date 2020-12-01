package com.chplalex.jpg2png.ui.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chplalex.jpg2png.R
import com.chplalex.jpg2png.mvp.presenter.TargetPresenter
import com.chplalex.jpg2png.mvp.view.TargetView
import com.chplalex.jpg2png.ui.App
import com.chplalex.jpg2png.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_target.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class TargetFragment : MvpAppCompatFragment(), TargetView, BackButtonListener {

    companion object {
        private const val URI_KEY = "FRAGMENT_TARGET_ARG_URI_KEY"
        private const val NAME_KEY = "FRAGMENT_TARGET_ARG_NAME_KEY"

        fun newInstance(uri: Uri, name: String) = TargetFragment().apply {
            arguments = Bundle().apply {
                putParcelable(URI_KEY, uri)
                putString(NAME_KEY, name)
            }
        }
    }

    private val presenter by moxyPresenter {
        val uri = arguments?.get(URI_KEY) as Uri
        val name = arguments?.getString(NAME_KEY) as String
        TargetPresenter(App.instance.router, uri, name)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = View.inflate(context, R.layout.fragment_target, null).also {
        activity?.title = resources.getString(R.string.label_fragment_target)
    }

    override fun backPressed() = presenter.backPressed()

    override fun setImage(data: Uri) {
        imgTarget.setImageURI(data)
    }

    override fun setText(data: String) {
        txtTarget.text = data
    }
}