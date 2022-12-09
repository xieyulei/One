package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.RecyclerFragmentSlideDeleteBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xieyulei
 * @date 2022-12-07
 */
class SlideDeleteRvFragment : BaseRecyclerFragment<RecyclerFragmentSlideDeleteBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentSlideDeleteBinding {
        return RecyclerFragmentSlideDeleteBinding.inflate(inflater)
    }

    override fun setupToolbar() {
    }

    override fun initView() {
    }
}