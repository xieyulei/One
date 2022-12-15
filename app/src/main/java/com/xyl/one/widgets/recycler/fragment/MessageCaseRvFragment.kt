package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.databinding.RecyclerFragmentMessageCaseBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * MessageCaseRvFragment
 * @author xieyulei
 * @date 2022-12-15
 */
class MessageCaseRvFragment : BaseRecyclerFragment<RecyclerFragmentMessageCaseBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentMessageCaseBinding {
        return RecyclerFragmentMessageCaseBinding.inflate(inflater)
    }

    override fun initView() {
    }

    override fun setupToolbar() {
        mBinding.messageCaseToolbar.apply {
            toolbarTitle.text = getString(R.string.recycler_message_case)
            toolbarBackFl.setOnClickListener { goBack() }
        }
    }
}