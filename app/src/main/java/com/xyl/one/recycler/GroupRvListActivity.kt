package com.xyl.one.recycler

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.databinding.ActivityGroupListBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * GroupRvListActivity
 * @author xieyulei
 * @date 2022-12-03
 */
class GroupRvListActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityGroupListBinding
    private lateinit var mAdapter: GroupRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityGroupListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        mAdapter = GroupRvAdapter(R.layout.rv_item_header, R.layout.rv_item, getGroupListData())

        mBinding.groupRv.apply {
            layoutManager = LinearLayoutManager(this@GroupRvListActivity)
            // 添加列表子项分隔线
            val decoration = DividerItemDecoration(this@GroupRvListActivity, LinearLayoutManager.VERTICAL)
            addItemDecoration(decoration)
            adapter = mAdapter
        }
    }

    class GroupRvAdapter(@LayoutRes headLayoutRes: Int, @LayoutRes itemLayoutRes: Int, data: MutableList<GroupFruit>) :
        BaseSectionQuickAdapter<GroupFruit, BaseViewHolder>(headLayoutRes, itemLayoutRes, data) {
        override fun convert(holder: BaseViewHolder, item: GroupFruit) {
            holder.setText(R.id.rv_item_tv, item.name)
                .setImageResource(R.id.rv_item_iv, item.imageId)
        }

        override fun convertHeader(helper: BaseViewHolder, item: GroupFruit) {
            helper.setText(R.id.rv_item_header_title, item.header)
        }
    }
}