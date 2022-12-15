package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.RecyclerFragmentListGridCaseBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * ListGridCaseRvFragment
 * @author xieyulei
 * @date 2022-12-15
 */
class ListGridCaseRvFragment : BaseRecyclerFragment<RecyclerFragmentListGridCaseBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentListGridCaseBinding {
        return RecyclerFragmentListGridCaseBinding.inflate(inflater)
    }

    override fun initView() {

    }

    override fun setupToolbar() {
        mBinding.listGridToolbar.apply {
            toolbarTitle.text = getString(R.string.recycler_list_grid_case)
            toolbarBackFl.setOnClickListener { goBack() }
        }
    }

}