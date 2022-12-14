package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.data.DataServer
import com.xyl.one.data.DataServer.RvItemBean
import com.xyl.one.databinding.RecyclerFragmentSlideDeleteBinding
import com.xyl.one.utils.showToast

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xyl
 * @date 2022-12-07
 */
class SlideDeleteRvFragment : BaseRecyclerFragment<RecyclerFragmentSlideDeleteBinding>() {

    private lateinit var mAdapter: SlideDeleteAdapter

    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentSlideDeleteBinding {
        return RecyclerFragmentSlideDeleteBinding.inflate(inflater)
    }

    override fun setupToolbar() {
        mBinding.slideDeleteToolbar.apply {
            toolbarTitle.text = getString(R.string.recycler_slide_delete)
            toolbarBackFl.setOnClickListener { goBack() }
        }
    }

    override fun initView() {
        mAdapter = SlideDeleteAdapter(R.layout.recycler_rv_slide_delete_item, DataServer.getSlideDeleteList())
        mBinding.slideDeleteRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
            adapter = mAdapter
        }

        mAdapter.addChildClickViewIds(
            R.id.rv_slide_delete_item_content_tv,
            R.id.rv_slide_delete_item_left_share,
            R.id.rv_slide_delete_item_right_delete,
            R.id.rv_slide_delete_item_right_favorite
        )
        mAdapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.rv_slide_delete_item_content_tv -> {
                    (adapter.data[position] as RvItemBean).title.showToast()
                }
                R.id.rv_slide_delete_item_left_share -> {
                    "${getString(R.string.recycler_text_share)}_${(adapter.data[position] as RvItemBean).title}".showToast()
                }
                R.id.rv_slide_delete_item_right_delete -> {
                    adapter.removeAt(position)
                }
                R.id.rv_slide_delete_item_right_favorite -> {
                    "${getString(R.string.recycler_text_favorite)}_${(adapter.data[position] as RvItemBean).title}".showToast()
                }
            }
        }
    }

    class SlideDeleteAdapter(layoutResId: Int, data: MutableList<RvItemBean>) : BaseQuickAdapter<RvItemBean, BaseViewHolder>(layoutResId, data) {
        override fun convert(holder: BaseViewHolder, item: RvItemBean) {
            holder.setText(R.id.rv_slide_delete_item_content_tv, item.title)
        }
    }
}