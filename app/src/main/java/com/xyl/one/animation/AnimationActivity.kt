package com.xyl.one.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xyl.one.databinding.AnimActivityHomeBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * AnimationActivity:后续重构一个RecyclerView,防止动画操作item
 * @author xyl
 * @date 2022-11-29
 */
class AnimationActivity : AppCompatActivity() {

    private lateinit var mBinding: AnimActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = AnimActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

//        mBinding.btnTweenAnim.setOnClickListener {
//            startActivity(Intent(this@AnimationActivity, TweenAnimActivity::class.java))
//        }
//
//        mBinding.btnActivityAnim.setOnClickListener {
//            startActivity(Intent(this@AnimationActivity, TransActAnimActivity::class.java))
//        }
//
//        mBinding.btnFragmentAnim.setOnClickListener {
//            startActivity(Intent(this@AnimationActivity, TransFragAnimActivity::class.java))
//        }
//
//        mBinding.btnListAnim.setOnClickListener {
//            startActivity(Intent(this@AnimationActivity, ListAnimActivity::class.java))
//        }
//
//        mBinding.btnFrameAnim.setOnClickListener {
//            startActivity(Intent(this@AnimationActivity, FrameAnimActivity::class.java))
//        }
//
//        mBinding.btnPropertyAnim.setOnClickListener {
//            startActivity(Intent(this@AnimationActivity, PropertyAnimActivity::class.java))
//        }
    }
}