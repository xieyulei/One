package com.xyl.one.widgets.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xyl.one.databinding.RecyclerActivityHomeBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * RecyclerViewActivity
 * @author xieyulei
 * @date 2022-12-03
 */
class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var mBinding: RecyclerActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = RecyclerActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}