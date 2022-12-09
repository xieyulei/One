package com.xyl.one.animation.fragment

import android.view.LayoutInflater
import android.view.animation.*
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.AnimFragmentTweenBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * PropertyAnimFragment
 * @author xyl
 * @date 2022-12-08
 */
class TweenAnimFragment : BaseRecyclerFragment<AnimFragmentTweenBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): AnimFragmentTweenBinding {
        return AnimFragmentTweenBinding.inflate(inflater)
    }

    override fun setupToolbar() {
        mBinding.animTweenToolbar.apply {
            toolbarTitle.text = getString(R.string.anim_tween)
            toolbarBackFl.setOnClickListener { goBack() }
        }
    }

    override fun initView() {
        showTweenAnimByXml()
        showTweenAnimByCode()
    }

    /**
     * xml方式
     */
    private fun showTweenAnimByXml() {
        // 平移
        mBinding.animTweenXmlTranslate.apply {
            val translateAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.view_tranlate_animation)
            setOnClickListener {
                mBinding.animTweenIv.startAnimation(translateAnim)
            }
        }

        // 缩放
        mBinding.animTweenXmlScale.apply {
            val translateAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.view_scale_animation)
            setOnClickListener {
                mBinding.animTweenIv.startAnimation(translateAnim)
            }
        }

        // 旋转
        mBinding.animTweenXmlRotate.apply {
            val translateAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.view_rotate_animation)
            setOnClickListener {
                mBinding.animTweenIv.startAnimation(translateAnim)
            }
        }

        // 透明度
        mBinding.animTweenXmlAlpha.apply {
            val translateAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.view_alpha_animation)
            setOnClickListener {
                mBinding.animTweenIv.startAnimation(translateAnim)
            }
        }
    }

    /**
     * code方式
     * 补间动画:平移、缩放、旋转、透明度
     */
    private fun showTweenAnimByCode() {
        // 平移
        mBinding.animTweenCodeTranslate.apply {
            val transAnim = TranslateAnimation(0f, 500f, 0f, 500f).apply {
                duration = 2000
                repeatCount = 2
                startOffset = 1000
                repeatMode = Animation.REVERSE
            }
            setOnClickListener {
                mBinding.animTweenIv.startAnimation(transAnim)
            }
        }

        // 缩放
        mBinding.animTweenCodeScale.apply {
            val scaleAnim = ScaleAnimation(0f, 2f, 0f, 2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f).apply {
                duration = 2000
                startOffset = 1000
                repeatCount = 2
                repeatMode = Animation.REVERSE
            }
            setOnClickListener {
                mBinding.animTweenIv.startAnimation(scaleAnim)
            }
        }

        // 旋转
        mBinding.animTweenCodeRotate.apply {
            val rotateAnim = RotateAnimation(0f, 270f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f).apply {
                duration = 2000
                startOffset = 1000
                repeatCount = 2
                repeatMode = Animation.REVERSE
            }
            setOnClickListener {
                mBinding.animTweenIv.startAnimation(rotateAnim)
            }
        }

        // 透明度
        mBinding.animTweenCodeAlpha.apply {
            val alphaAnim = AlphaAnimation(1.0f, 0.0f).apply {
                duration = 2000
                startOffset = 1000
                repeatCount = 2
                repeatMode = Animation.REVERSE
            }
            setOnClickListener {
                mBinding.animTweenIv.startAnimation(alphaAnim)
            }
        }
    }
}