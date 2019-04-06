package com.javaxian.applications.buildingservicesapp.domain.callback

import android.view.View

interface OnItemRecyclerClickListener<T> {

    /**
     * Interface definition for a callback to be invoked when a view is clicked.
     *
     * @param view the view that was clicked
     * @param position The position of the view that was clicked
     * @param item The object in the position of the view
     */
    abstract fun onItemRecyclerClick(view: View, position: Int, item: T)

}