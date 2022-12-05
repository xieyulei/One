package com.xyl.one.recycler.node

import com.chad.library.adapter.base.BaseNodeAdapter
import com.chad.library.adapter.base.entity.node.BaseNode
import com.xyl.one.recycler.FirstNode
import com.xyl.one.recycler.ItemType
import com.xyl.one.recycler.SecondNode
import com.xyl.one.recycler.ThirdNode

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * NodeTreeAdapter
 * @author xieyulei
 * @date 2022-12-05
 */
class NodeTreeAdapter(val mList: MutableList<BaseNode>? = null) : BaseNodeAdapter() {

    init {
        addNodeProvider(FirstProvider())
        addNodeProvider(SecondProvider())
        addNodeProvider(ThirdProvider())
    }

    override fun getItemType(data: List<BaseNode>, position: Int) =
        when (data[position]) {
            is FirstNode -> ItemType.ITEM_FIRST.itemType
            is SecondNode -> ItemType.ITEM_SECOND.itemType
            is ThirdNode -> ItemType.ITEM_THIRD.itemType
            else -> -1
        }
}