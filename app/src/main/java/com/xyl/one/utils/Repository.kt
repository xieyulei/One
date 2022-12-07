package com.xyl.one.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.xyl.one.R
import com.xyl.one.getString

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * Repository
 * @author xieyulei
 * @date 2022-12-07
 */

/**
 * RecyclerView通用item实体类
 */
data class RvItemBean(val title: String, val imageId: Int)

/**
 * 通用构建Item方法
 */
fun item(@StringRes titleId: Int, @DrawableRes imgIdRes: Int) = RvItemBean(getString(titleId), imgIdRes)

/**
 * Main Page Data
 */
fun getMainList(): MutableList<RvItemBean> = arrayListOf(
    item(R.string.main_widgets, R.drawable.ic_widgets),
    item(R.string.main_animation, R.drawable.ic_animation),
    item(R.string.main_jetpack, R.drawable.ic_jetpack)
)

/**
 * Widgets Page Data
 */
fun getWidgetsList(): MutableList<RvItemBean> = arrayListOf(
    item(R.string.widgets_recyclerview, R.drawable.ic_recycler)
)

/**
 * RecyclerView Page Data
 */
fun getRecyclerHomeList(): MutableList<RvItemBean> = arrayListOf(
    item(R.string.recycler_footer_header, R.drawable.ic_recycler),
    item(R.string.recycler_more_style, R.drawable.ic_recycler),
    item(R.string.recycler_node_grid, R.drawable.ic_recycler),
    item(R.string.recycler_node_tree, R.drawable.ic_recycler),
    item(R.string.recycler_drag_item, R.drawable.ic_recycler),
    item(R.string.recycler_slide_delete, R.drawable.ic_recycler)
)
