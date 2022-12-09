package com.xyl.one.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * BaseRecyclerFragment
 * @author xyl
 * @date 2022-12-07
 */
abstract class BaseRecyclerFragment<T : ViewBinding> : Fragment() {

    lateinit var mBinding: T
    private val mNavController: NavController
        get() = findNavController()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = inflateViewBinding(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        initView()
    }

    abstract fun inflateViewBinding(inflater: LayoutInflater): T

    abstract fun initView()

    abstract fun setupToolbar()

    fun go(@IdRes destination: Int, bundle: Bundle? = null) {
        mNavController.navigate(destination)
    }

    fun goBack() {
        mNavController.popBackStack()
    }
}