package com.xyl.one.animation.fragment

import android.view.LayoutInflater
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.AnimFragmentTweenBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * PropertyAnimFragment
 * @author xieyulei
 * @date 2022-12-08
 */
class TweenAnimFragment : BaseRecyclerFragment<AnimFragmentTweenBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): AnimFragmentTweenBinding {
        return AnimFragmentTweenBinding.inflate(inflater)
    }

    override fun initView() {
        mBinding.animTweenToolbar.apply {
            toolbarTitle.text = getString(R.string.animation_tween)
            toolbarBackFl.setOnClickListener { goBack() }
        }
    }
}