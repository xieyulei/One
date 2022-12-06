package com.xyl.one.recycler.node

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseNodeAdapter
import com.xyl.one.databinding.ActivityNodeTreeListBinding
import com.xyl.one.databinding.RvEmptyBinding
import com.xyl.one.recycler.getNodeTreeListData

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * NodeTreeListActivity
 * @author xieyulei
 * @date 2022-12-05
 */
class NodeTreeListActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityNodeTreeListBinding

    private lateinit var mAdapter: BaseNodeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityNodeTreeListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        mAdapter = NodeTreeAdapter()
        val emptyView = RvEmptyBinding.inflate(layoutInflater)
        mAdapter.setEmptyView(emptyView.root)
        mBinding.nodeTreeRv.apply {
            layoutManager = LinearLayoutManager(this@NodeTreeListActivity)
            adapter = mAdapter
            postDelayed({
                mAdapter.setList(getNodeTreeListData())
            }, 3000)
        }


    }
}