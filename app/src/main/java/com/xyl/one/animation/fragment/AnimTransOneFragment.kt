package com.xyl.one.animation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xyl.one.databinding.AnimFragmentOneBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * OneFragment
 * @author xieyulei
 * @date 2022-11-30
 */
class AnimTransOneFragment : Fragment() {

    private lateinit var mBinding: AnimFragmentOneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = AnimFragmentOneBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}