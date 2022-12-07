package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.RecylerFragmentNodeTreeBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xieyulei
 * @date 2022-12-07
 */
class NodeTreeRvFragment : BaseRecyclerFragment<RecylerFragmentNodeTreeBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): RecylerFragmentNodeTreeBinding {
        return RecylerFragmentNodeTreeBinding.inflate(inflater)
    }

    override fun initView() {
    }
}