package com.atmt.prpvideviewmodelfactorytest.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import com.atmt.prpvideviewmodelfactorytest.R
import com.atmt.prpvideviewmodelfactorytest.baseui.BaseFragment
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.atmt.prpvideviewmodelfactorytest.AppViewModelsFactory
import com.atmt.prpvideviewmodelfactorytest.ui.viewmodel.BlankViewModel
import javax.inject.Inject


class BlankFragment : BaseFragment() {
    override fun layoutId(): Int = R.layout.fragment_blank

    @Inject
    lateinit var vmFactory: AppViewModelsFactory

    lateinit var viewModel : BlankViewModel

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment()
    }

    private var listener: OnFragmentInteractionListener? = null

    override fun onViewReady(inflatedView: View, args: Bundle?) {

    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this, vmFactory).get(BlankViewModel::class.java)

        viewModel.stringToShowLiveData.observe(this, Observer{
            it?.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            } ?: Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
        })

        viewModel.getStringToShow()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

}
