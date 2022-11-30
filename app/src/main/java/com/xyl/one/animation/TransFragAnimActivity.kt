package com.xyl.one.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.xyl.one.R
import com.xyl.one.animation.fragment.OneFragment
import com.xyl.one.animation.fragment.TwoFragment
import com.xyl.one.databinding.ActivityTransFragAnimBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * TransFragActivity
 * @author xieyulei
 * @date 2022-11-30
 */
class TransFragAnimActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityTransFragAnimBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTransFragAnimBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnReplaceOne.setOnClickListener {
            replaceOneFragment(OneFragment())
        }

        mBinding.btnReplaceTwo.setOnClickListener {
            replaceTwoFragment(TwoFragment())
        }

        replaceTwoFragment(OneFragment())
    }

    private fun replaceOneFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.frag_container, fragment).commit()
    }

    private fun replaceTwoFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.in_from_right, R.anim.out_to_left)
            .replace(R.id.frag_container, fragment).commit()
    }
}