package com.xyl.one.recycler.node

import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.recycler.FirstNode
import com.xyl.one.recycler.ItemType

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
        helper.setText(R.id.tv_node_first,firstNode.title)
        helper.setImageResource(R.id.iv_node_first,firstNode.imageId)
    }
}