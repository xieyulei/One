package com.xyl.one.animation.fragment

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.AnimFragmentFrameBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * PropertyAnimFragment
 * @author xieyulei
 * @date 2022-12-08
 */
class FrameAnimFragment : BaseRecyclerFragment<AnimFragmentFrameBinding>() {

    private lateinit var mAnimationDrawable: AnimationDrawable

    override fun inflateViewBinding(inflater: LayoutInflater): AnimFragmentFrameBinding {
        return AnimFragmentFrameBinding.inflate(inflater)
    }

    override fun setupToolbar() {
        mBinding.animFrameToolbar.apply {
            toolbarTitle.text = getString(R.string.anim_frame)
            toolbarBackFl.setOnClickListener { goBack() }
        }
    }

    override fun initView() {
        showFrameAnimByXml()
        showFrameAnimByCode()
    }

    /**
     * 在资源文件中使用layer构建gif图
     */
    private fun showFrameAnimByXml() {
        mBinding.animFrameXmlStart.setOnClickListener {
            mBinding.animFrameIv.setImageResource(R.drawable.vkq_gif)
            mAnimationDrawable = mBinding.animFrameIv.drawable as AnimationDrawable
            mAnimationDrawable.stop()
            mAnimationDrawable.start()
        }

        mBinding.animFrameXmlStop.setOnClickListener {
            mBinding.animFrameIv.setImageResource(R.drawable.vkq_gif)
            mAnimationDrawable = mBinding.animFrameIv.drawable as AnimationDrawable
            mAnimationDrawable.stop()
        }
    }

    /**
     * 手动增加多张图片，形成gif图资源
     */
    private fun showFrameAnimByCode() {
        mAnimationDrawable = AnimationDrawable()

        // 直接从Drawable中取出资源，构建gif
        for (i in 1..15) {
            val id = resources.getIdentifier("vkq$i", "drawable", requireContext().packageName)
            val drawable = ContextCompat.getDrawable(requireContext(), id) as Drawable
            mAnimationDrawable.addFrame(drawable, 100)
        }

        mBinding.animFrameCodeStart.setOnClickListener {

            // 获取资源对象
            mBinding.animFrameIv.setImageDrawable(mAnimationDrawable)

            // 停止动画，消需要注意：开始动画之前要先stop,不然第一次动画之后会停在最后一帧，这样动画就只会触发一次
            mAnimationDrawable.stop()

            // 启动动画
            mAnimationDrawable.start()
        }

        mBinding.animFrameCodeStop.setOnClickListener {
            mBinding.animFrameIv.setImageDrawable(mAnimationDrawable)
            mAnimationDrawable.stop()
        }
    }
}