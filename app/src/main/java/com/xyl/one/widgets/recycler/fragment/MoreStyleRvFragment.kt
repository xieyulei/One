package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.data.DataServer
import com.xyl.one.data.DataServer.QuickMultipleEntity

import com.xyl.one.databinding.RecyclerFragmentMoreStyleBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xyl
 * @date 2022-12-07
 */
class MoreStyleRvFragment : BaseRecyclerFragment<RecyclerFragmentMoreStyleBinding>() {

    private lateinit var mAdapter: MoreStyleAdapter

    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentMoreStyleBinding {
        return RecyclerFragmentMoreStyleBinding.inflate(inflater)
    }

    override fun setupToolbar() {
        mBinding.moreStyleToolbar.apply {
            toolbarTitle.text = getString(R.string.recycler_more_style)
            toolbarBackFl.setOnClickListener {
                goBack()
            }
        }
    }

    override fun initView() {
        mAdapter = MoreStyleAdapter(DataServer.getMoreStyleListData())
        mBinding.moreStyleRv.apply {
            layoutManager = GridLayoutManager(requireContext(), 4)
            adapter = mAdapter
        }
        mAdapter.setGridSpanSizeLookup { _, _, position ->
            // 返回item占用网格的item个数宽度，即让当前的item占据几个位置
            mAdapter.data[position].spanSize
        }
    }

    class MoreStyleAdapter(data: MutableList<QuickMultipleEntity>) : BaseMultiItemQuickAdapter<QuickMultipleEntity, BaseViewHolder>(data) {

        init {
            addItemType(DataServer.ITEM_TYPE_TEXT, R.layout.recycler_text_style_item)
            addItemType(DataServer.ITEM_TYPE_IMAGE, R.layout.recycler_image_style_item)
            addItemType(DataServer.ITEM_TYPE_IMAGE_TEXT, R.layout.recycler_image_text_style_item)
        }

        override fun convert(holder: BaseViewHolder, item: QuickMultipleEntity) {
            when (item.itemType) {
                DataServer.ITEM_TYPE_TEXT -> {
                    holder.setText(R.id.rv_more_style_tv_item_title, item.content)
                    holder.setText(R.id.rv_more_style_tv_item_sub_title, item.subContent)
                }
                DataServer.ITEM_TYPE_IMAGE -> {
                    // 对于内容的处理
                }
                DataServer.ITEM_TYPE_IMAGE_TEXT -> {
                    holder.setText(R.id.rv_more_style_it_item_sub_title, item.content)
                }
            }
        }
    }
}