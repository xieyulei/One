package com.xyl.one.recycler.node

import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.recycler.ItemType
import com.xyl.one.recycler.SecondNode

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FirstProvider
 * @author xieyulei
 * @date 2022-12-05
 */
class SecondProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = ItemType.ITEM_SECOND.itemType

    override val layoutId: Int
        get() = R.layout.rv_item_node_second

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val secondNode = item as SecondNode
        helper.setText(R.id.tv_node_second, secondNode.title)
        helper.setImageResource(R.id.iv_node_second, secondNode.imageId)
    }
}