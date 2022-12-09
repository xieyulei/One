package com.xyl.one.widgets.recycler.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.data.RvItemBean
import com.xyl.one.data.getRecyclerNormalList
import com.xyl.one.databinding.RecyclerFragmentNativeBinding
import com.xyl.one.utils.showToast

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * NormalRvFragment
 * @author xyl
 * @date 2022-12-08
 */
class NativeRvFragment : BaseRecyclerFragment<RecyclerFragmentNativeBinding>() {

    private lateinit var mAdapter: NativeRvAdapter

    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentNativeBinding {
        return RecyclerFragmentNativeBinding.inflate(inflater)
    }

    override fun setupToolbar() {
        mBinding.nativeToolbar.apply {
            toolbarTitle.text = getString(R.string.recycler_native)
            toolbarBackFl.setOnClickListener {
                goBack()
            }
        }
    }

    override fun initView() {
        mAdapter = NativeRvAdapter(requireContext(), getRecyclerNormalList())
        mBinding.nativeRv.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = mAdapter
        }
    }

    /**
     * 自定义适配器
     */
    class NativeRvAdapter(val context: Context, val data: MutableList<RvItemBean>) : RecyclerView.Adapter<NativeRvAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val icon: ImageView = view.findViewById(R.id.recycler_rv_item_iv)
            val title: TextView = view.findViewById(R.id.recycler_rv_item_title)
        }

        // 创建ViewHolder实例
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_rv_item, parent, false)
            val viewHolder = ViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                val position = viewHolder.bindingAdapterPosition
                onClick(data, position)
            }
            return viewHolder
        }

        // 用于对RecyclerView子项的数据进行赋值，会在每个子项滚动到屏幕内的时候执行，通过position得到当前项的实例
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = data[position]
            holder.icon.setImageResource(item.imageId)
            holder.title.text = item.title
        }

        // 返回RecyclerView子项的数量，即数据源的长度
        override fun getItemCount(): Int = data.size

        // 处理子项点击事件
        private fun onClick(data: MutableList<RvItemBean>, position: Int) {
            data[position].title.showToast()
        }
    }
}