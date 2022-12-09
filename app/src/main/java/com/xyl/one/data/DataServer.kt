package com.xyl.one.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.chad.library.adapter.base.entity.SectionEntity
import com.chad.library.adapter.base.entity.node.BaseNode
import com.xyl.one.R
import com.xyl.one.utils.getString
import com.xyl.one.widgets.recycler.node.NodeTreeAdapter

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * DataServer
 * @author xieyulei
 * @date 2022-12-09
 */
object DataServer {

    /**
     * RecyclerView通用item实体类
     */
    data class RvItemBean(val title: String, val imageId: Int)

    /***
     * 定义分组列表实体类
     * 分组布局的实体类必须继承SectionEntity
     */
    data class RvGroupItemBean(val name: String, val imageId: Int, override val isHeader: Boolean = false, val header: String = "") : SectionEntity

    /**
     * 通用构建Item方法
     */
    fun item(@StringRes titleId: Int, @DrawableRes imgIdRes: Int) = RvItemBean(getString(titleId), imgIdRes)

    /**
     * Main Page Data
     */
    fun getMainList() = arrayListOf(
        item(R.string.main_widgets, R.drawable.ic_widgets),
        item(R.string.main_animation, R.drawable.ic_animation),
        item(R.string.main_jetpack, R.drawable.ic_jetpack),
        item(R.string.main_widgets, R.drawable.ic_widgets),
        item(R.string.main_animation, R.drawable.ic_animation),
        item(R.string.main_jetpack, R.drawable.ic_jetpack),
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

    /*********************************** RecyclerView ************************************/

    /**
     * RecyclerView Home Page Data
     */
    fun getRecyclerHomeList(): MutableList<RvItemBean> = arrayListOf(
        item(R.string.recycler_native, R.drawable.ic_recycler),
        item(R.string.recycler_footer_header, R.drawable.ic_recycler),
        item(R.string.recycler_group, R.drawable.ic_recycler),
        item(R.string.recycler_more_style, R.drawable.ic_recycler),
        item(R.string.recycler_node_tree, R.drawable.ic_recycler),
        item(R.string.recycler_node_grid, R.drawable.ic_recycler),
        item(R.string.recycler_drag_item, R.drawable.ic_recycler),
        item(R.string.recycler_slide_delete, R.drawable.ic_recycler)
    )

    /**
     * RecyclerView Normal Page Data
     */
    fun getRecyclerNormalList(): MutableList<RvItemBean> = arrayListOf(
        item(R.string.recycler_native, R.drawable.ic_recycler),
        item(R.string.recycler_footer_header, R.drawable.ic_recycler),
        item(R.string.recycler_group, R.drawable.ic_recycler),
        item(R.string.recycler_more_style, R.drawable.ic_recycler),
        item(R.string.recycler_node_tree, R.drawable.ic_recycler),
        item(R.string.recycler_node_grid, R.drawable.ic_recycler),
        item(R.string.recycler_drag_item, R.drawable.ic_recycler),
        item(R.string.recycler_slide_delete, R.drawable.ic_recycler)
    )

    /**
     * RecyclerView FooterHeader Page Data
     */
    fun getFooterHeaderList(): MutableList<RvItemBean> = arrayListOf(
        item(R.string.recycler_footer_header, R.drawable.ic_jetpack),
        item(R.string.recycler_footer_header, R.drawable.ic_jetpack),
        item(R.string.recycler_footer_header, R.drawable.ic_jetpack),
        item(R.string.recycler_footer_header, R.drawable.ic_jetpack),
        item(R.string.recycler_footer_header, R.drawable.ic_jetpack),
        item(R.string.recycler_footer_header, R.drawable.ic_jetpack),
        item(R.string.recycler_footer_header, R.drawable.ic_jetpack)
    )

    /**
     * 分组布局列表数据源
     */
    fun getGroupListData(): MutableList<RvGroupItemBean> {
        val fruitList = mutableListOf<RvGroupItemBean>()
        for (i in 0..40) {
            fruitList.add(RvGroupItemBean("${getString(R.string.widgets_recyclerview)}${i}", R.drawable.ic_jetpack, i % 5 == 0, "Head${i + 1}"))
        }
        return fruitList
    }

    /**
     * RecyclerView NodeTree Page Data
     */
    fun getNodeTreeListData(): MutableList<BaseNode> {
        val firstList = mutableListOf<BaseNode>()

        for (i in 0 until 10) {
            val secondList = mutableListOf<BaseNode>()
            for (j in 0 until 6) {
                val thirdList = mutableListOf<BaseNode>()
                for (k in 0 until 4) {
                    val node = NodeTreeAdapter.ThirdNode("${getString(R.string.recycler_node_text_third)}$k", R.mipmap.ic_launcher)
                    thirdList.add(node)
                }

                val secondNode = NodeTreeAdapter.SecondNode("${getString(R.string.recycler_node_text_second)}$j", R.mipmap.ic_launcher, thirdList)
                secondNode.isExpanded = (j == 0)
                secondList.add(secondNode)
            }
            val firstNode = NodeTreeAdapter.FirstNode("${getString(R.string.recycler_node_text_first)}$i", R.mipmap.ic_launcher, secondList)

            // 模拟 默认第0个是展开的
            firstNode.isExpanded = (i == 0)
            firstList.add(firstNode)
        }
        return firstList
    }

    /**
     * RecyclerView DragItem Page Data
     */
    fun getDragItemListData(): MutableList<RvItemBean> = arrayListOf(
        item(R.string.recycler_native, R.drawable.ic_jetpack),
        item(R.string.recycler_footer_header, R.drawable.ic_jetpack),
        item(R.string.recycler_node_tree, R.drawable.ic_jetpack),
        item(R.string.recycler_node_grid, R.drawable.ic_jetpack),
        item(R.string.recycler_drag_item, R.drawable.ic_jetpack)
    )
    /*********************************** Animation ************************************/

    /**
     * Animation Home Page Data
     */
    fun getAnimHomeDataList(): MutableList<RvItemBean> = arrayListOf(
        item(R.string.anim_tween, R.drawable.ic_jetpack),
        item(R.string.anim_property, R.drawable.ic_jetpack),
        item(R.string.anim_frame, R.drawable.ic_jetpack),
        item(R.string.anim_list, R.drawable.ic_jetpack),
        item(R.string.anim_act_trans, R.drawable.ic_jetpack),
        item(R.string.anim_frag_trans, R.drawable.ic_jetpack)
    )

    /**
     * Animation default data
     */
    fun getAnimDefaultDataList(): MutableList<RvItemBean> = arrayListOf(
        item(R.string.main_animation, R.drawable.ic_jetpack),
        item(R.string.main_animation, R.drawable.ic_jetpack),
        item(R.string.main_animation, R.drawable.ic_jetpack),
        item(R.string.main_animation, R.drawable.ic_jetpack),
        item(R.string.main_animation, R.drawable.ic_jetpack),
        item(R.string.main_animation, R.drawable.ic_jetpack),
        item(R.string.main_animation, R.drawable.ic_jetpack),
        item(R.string.main_animation, R.drawable.ic_jetpack)
    )
}