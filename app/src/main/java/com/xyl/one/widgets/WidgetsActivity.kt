package com.xyl.one.widgets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xyl.one.databinding.WidgetsActivityHomeBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * WidgetsActivity
 * @author xieyulei
 * @date 2022-12-06
 */
class WidgetsActivity : AppCompatActivity() {

    private lateinit var mBinding: WidgetsActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = WidgetsActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}