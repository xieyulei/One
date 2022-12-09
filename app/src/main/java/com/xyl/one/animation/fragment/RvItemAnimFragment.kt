package com.xyl.one.animation.fragment

import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.data.DataServer
import com.xyl.one.data.DataServer.RvItemBean
import com.xyl.one.databinding.AnimFragmentRvItemBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * RvItemAnimFragment
 * @author xyl
 * @date 2022-12-09
 */
class RvItemAnimFragment : BaseRecyclerFragment<AnimFragmentRvItemBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): AnimFragmentRvItemBinding {
        return AnimFragmentRvItemBinding.inflate(inflater)
    }

    override fun setupToolbar() {
        mBinding.listRvToolbar.apply {
            toolbarTitle.text = getString(R.string.anim_list)
            toolbarBackFl.setOnClickListener { goBack() }
        }
    }

    override fun initView() {
        val adapter = RecyclerAdapter(R.layout.rv_item, DataServer.getAnimDefaultDataList())
        mBinding.listRv.layoutManager = LinearLayoutManager(requireContext())

        // 为RecyclerView的item添加动画（此处为代码方式添加），另一种方式是在xml中，为recyclerView添加android:layoutAnimation属性
        // xml中使用属性添加动画 和 下面使用代码添加，两者同样的效果，关键点在于item里边的动画组合
//        val animation = AnimationUtils.loadAnimation(this, R.anim.item_anim)
//        val controller = LayoutAnimationController(animation).apply {
//            delay = 0.5f
//            order = LayoutAnimationController.ORDER_NORMAL
//        }
//        mBinding.listRv.layoutAnimation = controller

        mBinding.listRv.adapter = adapter
    }

    /**
     * 当前页的关键点在于xml中： android:layoutAnimation="@anim/layout_anim"的属性使用，正是因为这个属性，才可以使得item动画方式加载(详情见上方注释)
     */
    class RecyclerAdapter(layoutId: Int, data: MutableList<RvItemBean>) : BaseQuickAdapter<RvItemBean, BaseViewHolder>(layoutId, data) {
        override fun convert(holder: BaseViewHolder, item: RvItemBean) {
            holder.setText(R.id.rv_item_tv, item.title)
                .setImageResource(R.id.rv_item_iv, item.imageId)
        }
    }
}