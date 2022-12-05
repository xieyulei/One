package com.xyl.one.recycler

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xyl.one.databinding.ActivityRecyclerviewBinding
import com.xyl.one.recycler.node.NodeGridListActivity
import com.xyl.one.recycler.node.NodeTreeListActivity

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * RecyclerViewActivity
 * @author xieyulei
 * @date 2022-12-03
 */
class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRecyclerviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRecyclerviewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initListener()
    }


    private fun initListener() {
        mBinding.apply {
            btnNormal.setOnClickListener {
                startActivity(Intent(this@RecyclerViewActivity, NormalRvListActivity::class.java))
            }
            btnGroup.setOnClickListener {
                startActivity(Intent(this@RecyclerViewActivity, GroupRvListActivity::class.java))
            }
            btnNodeTree.setOnClickListener {
                startActivity(Intent(this@RecyclerViewActivity, NodeTreeListActivity::class.java))
            }
            btnNodeGrid.setOnClickListener {
                startActivity(Intent(this@RecyclerViewActivity, NodeGridListActivity::class.java))
            }
        }
    }
}