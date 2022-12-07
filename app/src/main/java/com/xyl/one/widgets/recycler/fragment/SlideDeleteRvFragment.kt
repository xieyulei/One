package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.RecylerFragmentSlideDeleteBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xieyulei
 * @date 2022-12-07
 */
class SlideDeleteRvFragment : BaseRecyclerFragment<RecylerFragmentSlideDeleteBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): RecylerFragmentSlideDeleteBinding {
        return RecylerFragmentSlideDeleteBinding.inflate(inflater)
    }

    override fun initView() {
    }
}