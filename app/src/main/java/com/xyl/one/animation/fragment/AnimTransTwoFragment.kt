package com.xyl.one.animation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xyl.one.databinding.AnimFragmentTwoBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * TwoFragment
 * @author xyl
 * @date 2022-11-30
 */
class AnimTransTwoFragment : Fragment() {
    private lateinit var mBinding: AnimFragmentTwoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = AnimFragmentTwoBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}