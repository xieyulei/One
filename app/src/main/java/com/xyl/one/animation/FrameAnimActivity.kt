package com.xyl.one.animation

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.xyl.one.R
import com.xyl.one.databinding.ActivityFrameAnimBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FrameAnimActivity：逐帧动画
 * @author xieyulei
 * @date 2022-11-30
 *
 * 应用场景：较为复杂的个性化动画效果
 * 逐帧动画--> 优点：使用简单、方便
 * 逐帧动画--> 缺点：容易引起OOM，因为使用大量&尺寸较大的图片资源
 * 使用注意点：避免使用尺寸较大的图片，否则会引起OOM
 *
 */
class FrameAnimActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityFrameAnimBinding
    private lateinit var mAnimationDrawable: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFrameAnimBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        showFrameAnimStyle1()
        showFrameAnimStyle2()
    }

    /**
     * 在资源文件中使用layer构建gif图
     */
    private fun showFrameAnimStyle1() {
        mBinding.btnStartXml.setOnClickListener {
            mBinding.ivGif.setImageResource(R.drawable.vkq_gif)
            mAnimationDrawable = mBinding.ivGif.drawable as AnimationDrawable
            mAnimationDrawable.stop()
            mAnimationDrawable.start()
        }

        mBinding.btnStopXml.setOnClickListener {
            mBinding.ivGif.setImageResource(R.drawable.vkq_gif)
            mAnimationDrawable = mBinding.ivGif.drawable as AnimationDrawable
            mAnimationDrawable.stop()
        }
    }

    /**
     * 手动增加多张图片，形成gif图资源
     */
    private fun showFrameAnimStyle2() {
        mAnimationDrawable = AnimationDrawable()

        // 直接从Drawable中取出资源，构建gif
        for (i in 1..27) {
            val id = resources.getIdentifier("vkq$i", "drawable", packageName)
            val drawable = ContextCompat.getDrawable(this, id) as Drawable
            mAnimationDrawable.addFrame(drawable, 100)
        }

        mBinding.btnStartCode.setOnClickListener {

            // 获取资源对象
            mBinding.ivGif.setImageDrawable(mAnimationDrawable)

            // 停止动画，消需要注意：开始动画之前要先stop,不然第一次动画之后会停在最后一帧，这样动画就只会触发一次
            mAnimationDrawable.stop()

            // 启动动画
            mAnimationDrawable.start()
        }

        mBinding.btnStopCode.setOnClickListener {
            mBinding.ivGif.setImageDrawable(mAnimationDrawable)
            mAnimationDrawable.stop()
        }
    }
}