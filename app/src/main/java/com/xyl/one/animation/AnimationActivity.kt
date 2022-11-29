package com.xyl.one.animation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xyl.one.databinding.ActivityAnimationBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * AnimationActivity:后续重构一个RecyclerView,防止动画操作item
 * @author xieyulei
 * @date 2022-11-29
 */
class AnimationActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnTweenAnim.setOnClickListener {
            startActivity(Intent(this@AnimationActivity, TweenAnimActivity::class.java))
        }

        mBinding.btnActivityAnim.setOnClickListener {
            startActivity(Intent(this@AnimationActivity, TransformAnimActivity::class.java))
        }
    }
}