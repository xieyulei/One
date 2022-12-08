package com.xyl.one.widgets.recycler.node

import com.chad.library.adapter.base.BaseNodeAdapter
import com.chad.library.adapter.base.entity.node.BaseExpandNode
import com.chad.library.adapter.base.entity.node.BaseNode

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * NodeTreeAdapter
 * @author xieyulei
 * @date 2022-12-05
 */
class NodeTreeAdapter(mList: MutableList<BaseNode>? = null) : BaseNodeAdapter(mList) {

    companion object {
        const val EXPAND_COLLAPSE_PAYLOAD = 110
    }

    enum class ItemType(val itemType: Int) {
        ITEM_FIRST(1),
        ITEM_SECOND(2),
        ITEM_THIRD(3)
    }

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

    class FirstNode(val title: String, val imageId: Int, override val childNode: MutableList<BaseNode>?) :
        BaseExpandNode() {
        init {
            isExpanded = false
        }
    }

    class SecondNode(val title: String, val imageId: Int, override val childNode: MutableList<BaseNode>?) :
        BaseExpandNode() {
        init {
            isExpanded = false
        }
    }

    class ThirdNode(val title: String, val imageId: Int, override val childNode: MutableList<BaseNode>? = null) : BaseNode()
}