package com.xyl.one.animation

import android.os.Bundle
import android.view.animation.*
import androidx.appcompat.app.AppCompatActivity
import com.xyl.one.R
import com.xyl.one.databinding.ActivityTweenAnimBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * TweenAnimActivity:补间动画
 * @author xieyulei
 * @date 2022-11-29
 */
class TweenAnimActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityTweenAnimBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTweenAnimBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        showXmlStyleAnimation()
        showCodeStyleAnimation()
    }

    /**
     * xml方式
     */
    private fun showXmlStyleAnimation() {
        // 平移
        mBinding.btnTranslateXml.apply {
            val translateAnim = AnimationUtils.loadAnimation(this@TweenAnimActivity, R.anim.view_tranlate_animation)
            setOnClickListener {
                mBinding.ivPng.startAnimation(translateAnim)
            }
        }

        // 缩放
        mBinding.btnScaleXml.apply {
            val translateAnim = AnimationUtils.loadAnimation(this@TweenAnimActivity, R.anim.view_scale_animation)
            setOnClickListener {
                mBinding.ivPng.startAnimation(translateAnim)
            }
        }

        // 旋转
        mBinding.btnRotateXml.apply {
            val translateAnim = AnimationUtils.loadAnimation(this@TweenAnimActivity, R.anim.view_rotate_animation)
            setOnClickListener {
                mBinding.ivPng.startAnimation(translateAnim)
            }
        }

        // 透明度
        mBinding.btnAlphaXml.apply {
            val translateAnim = AnimationUtils.loadAnimation(this@TweenAnimActivity, R.anim.view_alpha_animation)
            setOnClickListener {
                mBinding.ivPng.startAnimation(translateAnim)
            }
        }
    }

    /**
     * code方式
     * 补间动画:平移、缩放、旋转、透明度
     */
    private fun showCodeStyleAnimation() {
        // 平移
        mBinding.btnTranslateCode.apply {
            val transAnim = TranslateAnimation(0f, 500f, 0f, 500f).apply {
                duration = 2000
                repeatCount = 2
                startOffset = 1000
                repeatMode = Animation.REVERSE
            }
            setOnClickListener {
                mBinding.ivPng.startAnimation(transAnim)
            }
        }

        // 缩放
        mBinding.btnScaleCode.apply {
            val scaleAnim = ScaleAnimation(0f, 2f, 0f, 2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f).apply {
                duration = 2000
                startOffset = 1000
                repeatCount = 2
                repeatMode = Animation.REVERSE
            }
            setOnClickListener {
                mBinding.ivPng.startAnimation(scaleAnim)
            }
        }

        // 旋转
        mBinding.btnRotateCode.apply {
            val rotateAnim = RotateAnimation(0f, 270f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f).apply {
                duration = 2000
                startOffset = 1000
                repeatCount = 2
                repeatMode = Animation.REVERSE
            }
            setOnClickListener {
                mBinding.ivPng.startAnimation(rotateAnim)
            }
        }

        // 透明度
        mBinding.btnAlphaCode.apply {
            val alphaAnim = AlphaAnimation(1.0f, 0.0f).apply {
                duration = 2000
                startOffset = 1000
                repeatCount = 2
                repeatMode = Animation.REVERSE
            }
            setOnClickListener {
                mBinding.ivPng.startAnimation(alphaAnim)
            }
        }
    }
}