package com.xyl.one.animation.fragment

import android.view.LayoutInflater
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.AnimFragmentPropertyBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * PropertyAnimFragment
 * @author xieyulei
 * @date 2022-12-08
 */
class PropertyAnimFragment : BaseRecyclerFragment<AnimFragmentPropertyBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): AnimFragmentPropertyBinding {
        return AnimFragmentPropertyBinding.inflate(inflater)
    }

    override fun initView() {
        mBinding.animPropertyToolbar.apply {
            toolbarTitle.text = getString(R.string.anim_property)
            toolbarBackFl.setOnClickListener { goBack() }
        }
    }
}