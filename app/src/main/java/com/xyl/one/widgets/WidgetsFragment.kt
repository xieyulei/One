package com.xyl.one.widgets

import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.data.RvItemBean
import com.xyl.one.data.getWidgetsList
import com.xyl.one.databinding.FragmentWidgetsBinding
import com.xyl.one.databinding.RvWidgetsItemBinding
import com.xyl.one.getString
import com.xyl.one.startActivity
import com.xyl.one.widgets.recycler.RecyclerViewActivity

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * WidgetsFragment
 * @author xieyulei
 * @date 2022-12-07
 */
class WidgetsFragment : BaseRecyclerFragment<FragmentWidgetsBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentWidgetsBinding {
        return FragmentWidgetsBinding.inflate(inflater)
    }

    override fun initView() {
        mBinding.widgetsToolbar.apply {
            toolbarTitle.text = getString(R.string.main_widgets)
            toolbarBackFl.setOnClickListener {
                requireActivity().finish()
            }
        }

        val mAdapter = WidgetsAdapter(R.layout.rv_widgets_item, getWidgetsList())
        mBinding.widgetsRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }

    class WidgetsAdapter(@LayoutRes layoutRes: Int, data: MutableList<RvItemBean>? = null) :
        BaseQuickAdapter<RvItemBean, BaseViewHolder>(layoutRes, data) {
        override fun convert(holder: BaseViewHolder, item: RvItemBean) {
            val binding = RvWidgetsItemBinding.bind(holder.itemView)
            binding.rvWidgetsItemIv.setImageResource(item.imageId)
            binding.rvWidgetsItemTv.text = item.title

            binding.rvWidgetsItemLayout.setOnClickListener {
                val position = holder.bindingAdapterPosition
                when (data[position].title) {
                    getString(R.string.widgets_recyclerview) -> startActivity<RecyclerViewActivity>(this@WidgetsAdapter.context)
                }
            }
        }
    }


}