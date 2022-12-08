package com.xyl.one.widgets.recycler.node

import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.core.view.ViewCompat
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.widgets.recycler.node.NodeTreeAdapter.FirstNode
import com.xyl.one.widgets.recycler.node.NodeTreeAdapter.ItemType

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FirstProvider
 * @author xieyulei
 * @date 2022-12-05
 */
class FirstProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = ItemType.ITEM_FIRST.itemType

    override val layoutId: Int
        get() = R.layout.rv_item_node_first

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val firstNode = item as FirstNode
        helper.setText(R.id.tv_node_first, firstNode.title)
        helper.setImageResource(R.id.iv_node_first, firstNode.imageId)

        setArrowSpin(helper, item, false)
    }

    override fun convert(helper: BaseViewHolder, item: BaseNode, payloads: List<Any>) {
        for (payload in payloads) {
            if (payload is Int && payload == NodeTreeAdapter.EXPAND_COLLAPSE_PAYLOAD) {
                // 增量刷新，使用动画变化箭头
                setArrowSpin(helper, item, true)
            }
        }
    }

    private fun setArrowSpin(helper: BaseViewHolder, item: BaseNode, isAnimate: Boolean) {
        val firstNode = item as FirstNode
        val imageArrow = helper.getView<ImageView>(R.id.first_iv_arrow)

        if (firstNode.isExpanded) {
            if (isAnimate) {
                ViewCompat.animate(imageArrow).setDuration(200).setInterpolator(DecelerateInterpolator()).rotation(0f).start()
            } else {
                imageArrow.rotation = 0f
            }
        } else {
            if (isAnimate) {
                ViewCompat.animate(imageArrow).setDuration(200).setInterpolator(DecelerateInterpolator()).rotation(90f).start()
            } else {
                imageArrow.rotation = 90f
            }
        }
    }

    override fun onClick(helper: BaseViewHolder, view: View, data: BaseNode, position: Int) {
        // 这里使用payload进行增量刷新（避免整个item刷新导致的闪烁，不自然）
        getAdapter()!!.expandOrCollapse(position, animate = true, notify = true, parentPayload = NodeTreeAdapter.EXPAND_COLLAPSE_PAYLOAD)
    }
}