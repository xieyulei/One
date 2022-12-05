package com.xyl.one.recycler

import com.chad.library.adapter.base.entity.SectionEntity
import com.chad.library.adapter.base.entity.node.BaseExpandNode
import com.chad.library.adapter.base.entity.node.BaseNode
import com.xyl.one.R

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * RvUtils
 * @author xieyulei
 * @date 2022-12-03
 */

/**
 * 定义公共实体类
 */
data class Fruit(val name: String, val imageId: Int)

/**
 * NormalList数据源
 */
fun getListData(): MutableList<Fruit> {
    val fruitList = mutableListOf<Fruit>()
    for (i in 0..40) {
        fruitList.add(Fruit("Fruit${i + 1}", R.mipmap.ic_launcher_round))
    }
    return fruitList
}

/***
 * 定义分组列表实体类
 * 分组布局的实体类必须继承SectionEntity
 */
data class GroupFruit(val name: String, val imageId: Int, override val isHeader: Boolean = false, val header: String = "") : SectionEntity

/**
 * 分组布局列表数据源
 */
fun getGroupListData(): MutableList<GroupFruit> {
    val fruitList = mutableListOf<GroupFruit>()
    for (i in 0..40) {
        fruitList.add(GroupFruit("Fruit${i + 1}", R.mipmap.ic_launcher_round, i % 5 == 0, "Head${i + 1}"))
    }
    return fruitList
}

/**
 * 折叠列表的几种类型
 */
class FirstNode(val title: String, val imageId: Int, override val childNode: MutableList<BaseNode>?) :
    BaseExpandNode()

class SecondNode(val title: String, val imageId: Int, override val childNode: MutableList<BaseNode>?) :
    BaseExpandNode()

class ThirdNode(val title: String, val imageId: Int, override val childNode: MutableList<BaseNode>? = null) : BaseNode()

enum class ItemType(val itemType: Int) {
    ITEM_FIRST(1),
    ITEM_SECOND(2),
    ITEM_THIRD(3)
}

fun getNodeTreeListData(): MutableList<BaseNode> {
    val firstList = mutableListOf<BaseNode>()

    for (i in 0 until 10) {
        val secondList = mutableListOf<BaseNode>()
        for (j in 0 until 6) {
            val thirdList = mutableListOf<BaseNode>()
            for (k in 0 until 4) {
                val node = ThirdNode("Third Node $k", R.mipmap.ic_launcher)
                thirdList.add(node)
            }

            val secondNode = SecondNode("Second Node $j", R.mipmap.ic_launcher, thirdList)
            secondList.add(secondNode)
        }
        val firstNode = FirstNode("Fist Node $i", R.mipmap.ic_launcher, secondList)
        firstList.add(firstNode)
    }
    return firstList
}