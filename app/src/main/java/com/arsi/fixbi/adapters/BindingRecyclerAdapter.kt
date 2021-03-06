package com.arsi.fixbi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.arsi.fixbi.BR

/**
 * this is a generic adapter which can accommodate any kind of data
 * the only thing we need to do for every recyclerview is to make the list item layout and data binding will handle the rest
 * not recommended for very complex lists
 */
class BindingRecyclerAdapter<T, V>(private val viewModel: V, @LayoutRes val layout: Int, var data: ArrayList<T>) : RecyclerView.Adapter<BindingRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), layout, parent, false) as ViewDataBinding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.setVariable(BR.item, data.getOrNull(position))
            binding.setVariable(BR.viewModel, viewModel)
            binding.setVariable(BR.position, position)
        }
    }
}