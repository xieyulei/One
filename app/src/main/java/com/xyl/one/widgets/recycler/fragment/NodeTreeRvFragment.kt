package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.data.DataServer
import com.xyl.one.databinding.RecyclerFragmentNodeTreeBinding
import com.xyl.one.databinding.RvEmptyBinding
import com.xyl.one.widgets.recycler.node.NodeTreeAdapter

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xyl
 * @date 2022-12-07
 */
class NodeTreeRvFragment : BaseRecyclerFragment<RecyclerFragmentNodeTreeBinding>() {

    private lateinit var mAdapter: NodeTreeAdapter

    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentNodeTreeBinding {
        return RecyclerFragmentNodeTreeBinding.inflate(inflater)
    }

    override fun setupToolbar() {
        mBinding.nodeTreeToolbar.apply {
            toolbarTitle.text = getString(R.string.recycler_node_tree)
            toolbarBackFl.setOnClickListener {
                goBack()
            }
        }
    }

    override fun initView() {
        mAdapter = NodeTreeAdapter()
        val emptyView = RvEmptyBinding.inflate(layoutInflater)
        mAdapter.setEmptyView(emptyView.root)
        mBinding.nodeTreeRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
            postDelayed({
                mAdapter.setList(DataServer.getNodeTreeListData())
            }, 3000)
        }
    }
}