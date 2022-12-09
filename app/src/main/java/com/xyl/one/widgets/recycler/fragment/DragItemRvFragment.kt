package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemDragListener
import com.chad.library.adapter.base.module.DraggableModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.data.DataServer
import com.xyl.one.data.DataServer.RvItemBean
import com.xyl.one.databinding.RecyclerFragmentDragItemBinding
import com.xyl.one.utils.showToast

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xyl
 * @date 2022-12-07
 */
class DragItemRvFragment : BaseRecyclerFragment<RecyclerFragmentDragItemBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentDragItemBinding {
        return RecyclerFragmentDragItemBinding.inflate(inflater)
    }

    override fun setupToolbar() {
        mBinding.dragItemToolbar.apply {
            toolbarTitle.text = getString(R.string.recycler_drag_item)
            toolbarBackFl.setOnClickListener { goBack() }
        }
    }

    override fun initView() {
        val itemDragListener = object : OnItemDragListener {
            private var position: Int = 0
            override fun onItemDragStart(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
                position = pos
                viewHolder?.itemView?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.drag_item_bg_color))
            }

            override fun onItemDragMoving(source: RecyclerView.ViewHolder?, from: Int, target: RecyclerView.ViewHolder?, to: Int) {}

            override fun onItemDragEnd(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
                context?.let {
                    viewHolder?.itemView?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.rv_item_bg_color))
                    if (position != pos) {
                        // 可以在此进行数据相关的排序逻辑处理
                    }
                }
            }
        }

        val mAdapter = DragItemAdapter(R.layout.recycler_rv_item, DataServer.getDragItemListData())

        // Setting Drag config
        mAdapter.draggableModule.isDragEnabled = true
        mAdapter.draggableModule.setOnItemDragListener(itemDragListener)
        mAdapter.draggableModule.itemTouchHelperCallback.setDragMoveFlags(ItemTouchHelper.UP or ItemTouchHelper.DOWN)

        mBinding.dragItemRv.layoutManager = LinearLayoutManager(requireContext())
        mBinding.dragItemRv.adapter = mAdapter

        mAdapter.setOnItemClickListener { adapter, _, position ->
            "position is $position , title is ${(adapter.data[position] as RvItemBean).title}".showToast()
        }
    }

    class DragItemAdapter(layoutId: Int, data: MutableList<RvItemBean>) : BaseQuickAdapter<RvItemBean, BaseViewHolder>(layoutId, data),
        DraggableModule {
        override fun convert(holder: BaseViewHolder, item: RvItemBean) {
            holder.apply {
                setText(R.id.recycler_rv_item_title, item.title)
                setImageResource(R.id.recycler_rv_item_iv, item.imageId)
            }
        }
    }
}