package com.javaxian.applications.buildingservicesapp.presentation.fragment.main.rejected

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
import com.javaxian.applications.buildingservicesapp.presentation.fragment.main.rejected.presenter.IRejectedPresenter
import com.javaxian.applications.buildingservicesapp.presentation.fragment.main.rejected.presenter.RejectedPresenterImpl
import com.javaxian.applications.buildingservicesapp.presentation.view.adapter.RejectedRecycler

class RejectedFragment : Fragment(), IRejectedPresenter.View, OnItemRecyclerClickListener<PaymentEntity> {

    lateinit var presenter: RejectedPresenterImpl

    var rootView: View? = null
    var recyclerView: RecyclerView? = null
    var adapter: RejectedRecycler? = null

    companion object {
        fun newInstance(args: Bundle?): RejectedFragment {

            var fragmentRejected = RejectedFragment()
            fragmentRejected.setHasOptionsMenu(true)
            fragmentRejected.arguments = args

            return fragmentRejected
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_rejected, container, false);

        recyclerView = rootView?.findViewById(R.id.main_recycler_clients_rejected)

        initPresenter()
        initResources()

        return rootView
    }


    private fun initPresenter(){
        presenter = RejectedPresenterImpl()
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
        adapter = RejectedRecycler(clients, this)
        recyclerView?.setAdapter(adapter)
    }

    override fun onItemRecyclerClick(view: View, position: Int, item: PaymentEntity) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("object_id", item as Parcelable)
        startActivity(intent)
    }
}