package com.xyl.one.animation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xyl.one.databinding.FragmentTwoAnimBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * TwoFragment
 * @author xieyulei
 * @date 2022-11-30
 */
class TwoFragment : Fragment() {
    private lateinit var mBinding: FragmentTwoAnimBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentTwoAnimBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}