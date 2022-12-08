package com.xyl.one.animation.fragment

import android.view.LayoutInflater
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
    override fun inflateViewBinding(inflater: LayoutInflater): AnimFragmentFrameBinding {
        return AnimFragmentFrameBinding.inflate(inflater)
    }

    override fun initView() {
        mBinding.animFrameToolbar.apply {
            toolbarTitle.text = getString(R.string.animation_frame)
            toolbarBackFl.setOnClickListener { goBack() }
        }
    }
}