package com.javaxian.applications.buildingservicesapp.presentation.fragment.main.authorized

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.javaxian.applications.buildingservicesapp.R
import com.javaxian.applications.buildingservicesapp.domain.callback.OnItemRecyclerClickListener
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity
import com.javaxian.applications.buildingservicesapp.presentation.activity.DetailActivity
import com.javaxian.applications.buildingservicesapp.presentation.fragment.main.authorized.presenter.AuthorizedPresenterImpl
import com.javaxian.applications.buildingservicesapp.presentation.fragment.main.authorized.presenter.IAuthorizedPresenter
import com.javaxian.applications.buildingservicesapp.presentation.view.adapter.AuthorizedRecycler

class AuthorizedFragment : Fragment(), IAuthorizedPresenter.View, OnItemRecyclerClickListener<PaymentEntity> {


    lateinit var presenter: AuthorizedPresenterImpl

    var rootView: View? = null
    var recyclerView: RecyclerView? = null
    var adapter: AuthorizedRecycler? = null

    companion object {
        fun newInstance(args: Bundle?): AuthorizedFragment {

            var fragmentAuthorized = AuthorizedFragment()
            fragmentAuthorized.setHasOptionsMenu(true)
            fragmentAuthorized.arguments = args

            return fragmentAuthorized
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_authorized, container, false);

        recyclerView = rootView?.findViewById(R.id.main_recycler_clients)

        initPresenter()
        initResources()

        return rootView
    }

    private fun initPresenter(){
        presenter = AuthorizedPresenterImpl()
        presenter.setView(this)
        presenter.setActivity(activity!!)
        presenter.setContext(context!!)
        presenter.initialize()
        presenter.onGetClients()
    }

    private fun initResources(){

        val llmGral = LinearLayoutManager(activity)
        llmGral.orientation = LinearLayoutManager.VERTICAL
        recyclerView?.setHasFixedSize(true)
        recyclerView?.setLayoutManager(llmGral)

    }

    override fun initView(clients: ArrayList<PaymentEntity>) {

        adapter = AuthorizedRecycler(clients, this)
        recyclerView?.setAdapter(adapter)

    }

    override fun onItemRecyclerClick(view: View, position: Int, item: PaymentEntity) {

        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("object_id", item as Parcelable)
        startActivity(intent)
    }
}