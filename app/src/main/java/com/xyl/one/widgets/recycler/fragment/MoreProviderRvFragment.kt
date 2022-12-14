package com.xyl.one.widgets.recycler.fragment

import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.data.DataServer
import com.xyl.one.databinding.RecyclerFragmentMoreProviderBinding
import com.xyl.one.widgets.recycler.provider.ProviderMultiAdapter

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * MoreProviderRvFragment
 * @author xyl
 * @date 2022-12-14
 */
class MoreProviderRvFragment : BaseRecyclerFragment<RecyclerFragmentMoreProviderBinding>() {

    private lateinit var mAdapter: ProviderMultiAdapter

    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentMoreProviderBinding {
        return RecyclerFragmentMoreProviderBinding.inflate(inflater)
    }

    override fun initView() {
        mAdapter = ProviderMultiAdapter(DataServer.getMoreProviderListData())
        mBinding.moreProviderRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }

    override fun setupToolbar() {
        mBinding.moreProviderToolbar.apply {
            toolbarTitle.text = getString(R.string.recycler_more_provider)
            toolbarBackFl.setOnClickListener {
                goBack()
            }
        }
    }
}