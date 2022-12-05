package com.xyl.one.recycler.node

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xyl.one.databinding.ActivityNodeGridListBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * NodeGridListActivity
 * @author xieyulei
 * @date 2022-12-05
 */
class NodeGridListActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityNodeGridListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityNodeGridListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}