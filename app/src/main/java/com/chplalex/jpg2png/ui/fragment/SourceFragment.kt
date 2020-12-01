package com.chplalex.jpg2png.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chplalex.jpg2png.R
import com.chplalex.jpg2png.mvp.presenter.SourcePresenter
import com.chplalex.jpg2png.mvp.view.SourceView
import com.chplalex.jpg2png.ui.App
import com.chplalex.jpg2png.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_source.*
import moxy.MvpAppCompatActivity
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SourceFragment : MvpAppCompatFragment(), SourceView, BackButtonListener {

    companion object {
        fun newInstance() = SourceFragment()

        private const val OPEN_IMAGE_REQUEST_CODE = 0x33
    }

    private val presenter by moxyPresenter {
        SourcePresenter(requireContext(), App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_source, container, false).apply {
        activity?.title = resources.getString(R.string.label_fragment_source)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn.setOnClickListener { presenter.btnClicked() }
        fab.setOnClickListener { openImagePicker() }
    }

    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            type = "image/jpeg"
            addCategory(Intent.CATEGORY_OPENABLE)
        }
        startActivityForResult(intent, OPEN_IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        super.onActivityResult(requestCode, resultCode, resultData)
        if (requestCode == OPEN_IMAGE_REQUEST_CODE && resultCode == MvpAppCompatActivity.RESULT_OK) {
            resultData?.data?.also {
                presenter.setData(it)
            }
        }
    }

    override fun init() {
        imgSource.setImageResource(R.drawable.ic_no_image)
        txtSource.setText(R.string.image_not_selected)
    }

    override fun setImage(data: Uri) {
        imgSource.setImageURI(data)
    }

    override fun setText(data: String) {
        txtSource.text = data
    }

    override fun backPressed() = presenter.backClicked()
}