package com.xyl.one.jetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xyl.one.databinding.JetpackActivityHomeBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * JetpackActivity
 * @author xyl
 * @date 2022-12-06
 */
class JetpackActivity : AppCompatActivity() {

    private lateinit var mBinding: JetpackActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = JetpackActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}