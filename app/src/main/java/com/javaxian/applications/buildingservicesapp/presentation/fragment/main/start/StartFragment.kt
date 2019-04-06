package com.javaxian.applications.buildingservicesapp.presentation.fragment.main.start

import android.os.Bundle
import android.support.v4.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.javaxian.applications.buildingservicesapp.R
import com.javaxian.applications.buildingservicesapp.presentation.fragment.main.start.presenter.IStartPresenter
import com.javaxian.applications.buildingservicesapp.presentation.fragment.main.start.presenter.StartPresenterImpl
import com.javaxian.applications.buildingservicesapp.utils.DebugUtils
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment(), IStartPresenter.View, View.OnClickListener{


    lateinit var presenter: StartPresenterImpl

    var rootView: View? = null

    companion object {
        fun newInstance(args: Bundle?): StartFragment {

            var fragmentStart = StartFragment()
            fragmentStart.setHasOptionsMenu(true)
            fragmentStart.arguments = args

            return fragmentStart
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_start, container, false);

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPresenter()
        initResources()
    }

    private fun initPresenter(){
        presenter = StartPresenterImpl()
        presenter.setView(this)
        presenter.setActivity(activity!!)
        presenter.setContext(context!!)
        presenter.initialize()

    }

    private fun initResources(){
        download_button.setOnClickListener(this)
    }

    override fun initView() {

    }

    override fun onClick(view: View?) {

        when(view?.id){

            R.id.download_button -> presenter.onGetPayments()

        }
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showResult(message: String) {
        Toast.makeText(activity,message, Toast.LENGTH_LONG).show()
    }

    override fun enableButton() {
        download_button.isEnabled = true
        download_button.setBackgroundResource(R.drawable.ripple_oval)
    }

    override fun disableButton() {
        download_button.isEnabled = false
        download_button.setBackgroundResource(R.drawable.ripple_oval_disable)
    }

}