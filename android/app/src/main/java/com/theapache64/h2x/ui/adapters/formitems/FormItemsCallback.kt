package com.theapache64.h2x.ui.adapters.formitems

interface FormItemsCallback {
    fun onDeleteClicked(position: Int)
    fun onSetFromDateClicked(position: Int)
    fun onSetToDateClicked(position: Int)
}