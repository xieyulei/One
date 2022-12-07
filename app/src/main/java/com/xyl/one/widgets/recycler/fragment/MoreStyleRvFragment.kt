package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.RecylerFragmentMoreStyleBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xieyulei
 * @date 2022-12-07
 */
class MoreStyleRvFragment : BaseRecyclerFragment<RecylerFragmentMoreStyleBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): RecylerFragmentMoreStyleBinding {
        return RecylerFragmentMoreStyleBinding.inflate(inflater)
    }

    override fun initView() {
    }

}