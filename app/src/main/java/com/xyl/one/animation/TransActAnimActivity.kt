package com.xyl.one.animation

import android.os.Bundle
import androidx.appcompat.R
import androidx.appcompat.app.AppCompatActivity
import com.xyl.one.databinding.AnimActivityTransActBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * TransformAnimActivity:Activity进入、退出动画切换效果演示
 * @author xyl
 * @date 2022-11-29
 *
 *
 * 系统已经封装好的动画效果
 * 淡入淡出：android.R.anim.fade_in、android.R.anim.fade_out
 * 由左向右滑入：android.R.anim.slide_in_left、android.R.anim.slide_out_right
 *
 * 核心方法：overridePendingTransition（int enterAnim, int exitAnim）
 * 调用时机：Activity的onCreate() 或 finish()
 *
 * 参数说明
 * 对于在onCreate()设置：
 * enterAnim：进入该Activity时的动画效果资源ID
 * exitAnim：进入该Activity时上一个Activity离开时的动画效果资源ID
 *
 * 对于在finish()设置：
 * enterAnim：进入其他Activity时 进入Activity的动画效果资源ID
 * exitAnim：进入其他Activity时 该Activity离开时的动画效果资源ID
 */
class TransActAnimActivity : AppCompatActivity() {

    private lateinit var mBinding: AnimActivityTransActBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        mBinding = AnimActivityTransActBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.transActToolbar.apply {
            toolbarTitle.text = getString(com.xyl.one.R.string.anim_act_trans)
            toolbarBackFl.setOnClickListener {
                finish()
            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
    }
}