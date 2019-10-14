package com.theapache64.h2x.ui.adapters.formitems

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.theapache64.h2x.databinding.ItemFormItemBinding
import com.theapache64.h2x.models.FormItem

class FormItemsAdapter(
    context: Context,
    private val formItems: List<FormItem>,
    private val callback: FormItemsCallback
) : RecyclerView.Adapter<FormItemsAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFormItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = formItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val formItem = formItems[position]
        holder.binding.position = position
        holder.binding.formItem = formItem
        holder.binding.callback = callback
    }

    inner class ViewHolder(val binding: ItemFormItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}
