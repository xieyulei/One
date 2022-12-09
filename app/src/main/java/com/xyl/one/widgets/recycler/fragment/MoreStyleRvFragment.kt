package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.RecyclerFragmentMoreStyleBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xyl
 * @date 2022-12-07
 */
class MoreStyleRvFragment : BaseRecyclerFragment<RecyclerFragmentMoreStyleBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentMoreStyleBinding {
        return RecyclerFragmentMoreStyleBinding.inflate(inflater)
    }

    override fun setupToolbar() {
    }

    override fun initView() {
    }

}