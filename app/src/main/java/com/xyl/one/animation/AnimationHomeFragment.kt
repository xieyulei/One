package com.xyl.one.animation

import android.view.LayoutInflater
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.data.DataServer
import com.xyl.one.data.DataServer.RvItemBean
import com.xyl.one.databinding.AnimFragmentHomeBinding
import com.xyl.one.utils.startActivity

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * AnimationFragment
 * @author xyl
 * @date 2022-12-08
 */
class AnimationHomeFragment : BaseRecyclerFragment<AnimFragmentHomeBinding>() {

    private lateinit var mAdapter: AnimHomeAdapter

    override
    fun inflateViewBinding(inflater: LayoutInflater): AnimFragmentHomeBinding {
        return AnimFragmentHomeBinding.inflate(inflater)
    }

    override fun setupToolbar() {
        mBinding.animHomeToolbar.apply {
            toolbarTitle.text = getString(R.string.main_animation)
            toolbarBackFl.setOnClickListener {
                requireActivity().finish()
            }
        }
    }

    override fun initView() {
        mAdapter = AnimHomeAdapter(R.layout.anim_home_rv_item, DataServer.getAnimHomeDataList())
        mBinding.animHomeRv.adapter = mAdapter
        mAdapter.setOnItemClickListener { adapter, _, position ->
            val itemBean = adapter.data[position] as RvItemBean
            when (itemBean.title) {
                getString(R.string.anim_tween) -> go(R.id.home_to_tween)
                getString(R.string.anim_property) -> go(R.id.home_to_property)
                getString(R.string.anim_frame) -> go(R.id.home_to_frame)
                getString(R.string.anim_list) -> go(R.id.home_to_rvItem)
                getString(R.string.anim_act_trans) -> startActivity<TransActAnimActivity>(requireContext())
                getString(R.string.anim_frag_trans) -> startActivity<TransFragAnimActivity>(requireContext())
            }
        }
    }

    class AnimHomeAdapter(layoutId: Int, data: MutableList<RvItemBean>? = null) : BaseQuickAdapter<RvItemBean, BaseViewHolder>(layoutId, data) {
        override fun convert(holder: BaseViewHolder, item: RvItemBean) {
            holder.setText(R.id.anim_rv_item_title, item.title)
                .setImageResource(R.id.anim_rv_item_icon, item.imageId)
        }
    }

}