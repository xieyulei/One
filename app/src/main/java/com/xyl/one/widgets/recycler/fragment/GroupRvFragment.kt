package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.data.GroupFruit
import com.xyl.one.data.getGroupListData
import com.xyl.one.databinding.RecyclerFragmentGroupBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xyl
 * @date 2022-12-07
 */
class GroupRvFragment : BaseRecyclerFragment<RecyclerFragmentGroupBinding>() {

    private lateinit var mAdapter: GroupRvAdapter

    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentGroupBinding {
        return RecyclerFragmentGroupBinding.inflate(inflater)
    }

    override fun setupToolbar() {
        mBinding.groupToolbar.apply {
            toolbarTitle.text = getString(R.string.recycler_group)
            toolbarBackFl.setOnClickListener {
                goBack()
            }
        }
    }

    override fun initView() {
        mAdapter = GroupRvAdapter(R.layout.rv_item_header, R.layout.recycler_rv_item, getGroupListData())

        mBinding.groupRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            // 添加列表子项分隔线
            val decoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            addItemDecoration(decoration)
            adapter = mAdapter
        }
        mAdapter.setOnItemClickListener { _, _, position ->
            val groupFruit = mAdapter.data[position]
            when (groupFruit.isHeader) {
                true -> {
                    Toast.makeText(requireContext(), "Header position = $position", Toast.LENGTH_SHORT).show()
                }
                false -> {
                    Toast.makeText(requireContext(), "Item position = $position", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    class GroupRvAdapter(@LayoutRes headLayoutRes: Int, @LayoutRes itemLayoutRes: Int, data: MutableList<GroupFruit>) :
        BaseSectionQuickAdapter<GroupFruit, BaseViewHolder>(headLayoutRes, itemLayoutRes, data) {
        override fun convert(holder: BaseViewHolder, item: GroupFruit) {
            holder.setText(R.id.recycler_rv_item_title, item.name)
                .setImageResource(R.id.recycler_rv_item_iv, item.imageId)
        }

        override fun convertHeader(helper: BaseViewHolder, item: GroupFruit) {
            helper.setText(R.id.rv_item_header_title, item.header)
        }
    }
}