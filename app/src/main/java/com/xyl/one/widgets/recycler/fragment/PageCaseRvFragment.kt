package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.RecyclerFragmentPageCaseBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * PageCaseRvFragment
 * @author xieyulei
 * @date 2022-12-15
 */
class PageCaseRvFragment : BaseRecyclerFragment<RecyclerFragmentPageCaseBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentPageCaseBinding {
        return RecyclerFragmentPageCaseBinding.inflate(inflater)
    }

    override fun initView() {
        mBinding.pageCaseToolbar.apply {
            toolbarTitle.text = getString(R.string.recycler_page_case)
            toolbarBackFl.setOnClickListener { goBack() }
        }
    }

    override fun setupToolbar() {

    }
}