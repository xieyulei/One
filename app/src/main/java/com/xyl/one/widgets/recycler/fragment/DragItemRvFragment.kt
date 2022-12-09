package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.RecyclerFragmentDragItemBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xieyulei
 * @date 2022-12-07
 */
class DragItemRvFragment : BaseRecyclerFragment<RecyclerFragmentDragItemBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentDragItemBinding {
        return RecyclerFragmentDragItemBinding.inflate(inflater)
    }

    override fun setupToolbar() {
    }

    override fun initView() {

    }
}