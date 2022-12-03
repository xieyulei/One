package com.xyl.one.recycler

import com.chad.library.adapter.base.entity.SectionEntity
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