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
        private const val ARG_KEY = "FRAGMENT_TARGET_ARG_KEY"

        fun newInstance(uri: Uri) = TargetFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_KEY, uri)
            }
        }
    }

    private val presenter by moxyPresenter {
        val uri = arguments?.get(ARG_KEY) as Uri
        TargetPresenter(requireContext(), App.instance.router, uri)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_target, container, false).also {
        activity?.title = resources.getString(R.string.label_fragment_target)
    }

    override fun backPressed() = presenter.backClick()

    override fun setImage(data: Uri) {
        imgTarget.setImageURI(data)
    }

    override fun setText(data: String) {
        txtTarget.text = data
    }
}