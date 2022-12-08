package com.xyl.one.widgets.recycler.node

import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.widgets.recycler.node.NodeTreeAdapter.ItemType
import com.xyl.one.widgets.recycler.node.NodeTreeAdapter.ThirdNode

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FirstProvider
 * @author xieyulei
 * @date 2022-12-05
 */
class ThirdProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = ItemType.ITEM_THIRD.itemType

    override val layoutId: Int
        get() = R.layout.rv_item_node_third

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val thirdNode = item as ThirdNode
        helper.setText(R.id.tv_node_third, thirdNode.title)
        helper.setImageResource(R.id.iv_node_third, thirdNode.imageId)
    }
}