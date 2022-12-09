package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.RecyclerFragmentNodeGridBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xyl
 * @date 2022-12-07
 */
class NodeGridRvFragment : BaseRecyclerFragment<RecyclerFragmentNodeGridBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentNodeGridBinding {
        return RecyclerFragmentNodeGridBinding.inflate(inflater)
    }

    override fun setupToolbar() {
    }

    override fun initView() {
    }
}