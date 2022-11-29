package com.xyl.one

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.xyl.one.animation.AnimationActivity
import com.xyl.one.databinding.ActivityMainBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * MainActivity
 * @author xieyulei
 * @date 2022-11-25
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        Log.e("xyl", "This is MainActivity.")
        mBinding.btnAnimation.setOnClickListener {
            startActivity(Intent(this@MainActivity, AnimationActivity::class.java))
        }
    }
}