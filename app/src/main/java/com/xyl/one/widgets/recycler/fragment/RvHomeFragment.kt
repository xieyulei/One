package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.data.RvItemBean
import com.xyl.one.data.getRecyclerHomeList
import com.xyl.one.databinding.RecyclerFragmentHomeBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * HomeRvFragment
 * @author xyl
 * @date 2022-12-07
 */
class RvHomeFragment : BaseRecyclerFragment<RecyclerFragmentHomeBinding>() {

    private lateinit var mAdapter: HomeRvAdapter

    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentHomeBinding {
        return RecyclerFragmentHomeBinding.inflate(inflater)
    }

    override fun setupToolbar() {
        mBinding.recyclerToolbar.apply {
            toolbarTitle.text = getString(R.string.recycler_home_title)
            toolbarBackFl.setOnClickListener {
                requireActivity().finish()
            }
        }
    }

    override fun initView() {
        mAdapter = HomeRvAdapter(R.layout.recycler_rv_item, getRecyclerHomeList())
        mBinding.recyclerHomeRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
            adapter = mAdapter
        }
        mAdapter.setOnItemClickListener { _, _, position ->
            when (mAdapter.data[position].title) {
                getString(R.string.recycler_native) -> go(R.id.home_to_native)
                getString(R.string.recycler_footer_header) -> go(R.id.home_to_footerHeader)
                getString(R.string.recycler_group) -> go(R.id.home_to_group)
                getString(R.string.recycler_more_style) -> go(R.id.home_to_moreStyle)
                getString(R.string.recycler_node_tree) -> go(R.id.home_to_nodeTree)
                getString(R.string.recycler_node_grid) -> go(R.id.home_to_nodeGrid)
                getString(R.string.recycler_drag_item) -> go(R.id.home_to_dragItem)
                getString(R.string.recycler_slide_delete) -> go(R.id.home_to_slideDelete)
            }
        }
    }

    class HomeRvAdapter(@LayoutRes layoutRes: Int, data: MutableList<RvItemBean>? = null) :
        BaseQuickAdapter<RvItemBean, BaseViewHolder>(layoutRes, data) {
        override fun convert(holder: BaseViewHolder, item: RvItemBean) {
            holder.setText(R.id.recycler_rv_item_title, item.title).setImageResource(R.id.recycler_rv_item_iv, item.imageId)
        }
    }
}