package com.xyl.one.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.xyl.one.R
import com.xyl.one.animation.fragment.AnimTransOneFragment
import com.xyl.one.animation.fragment.AnimTransTwoFragment
import com.xyl.one.databinding.AnimActivityTransFragBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * TransFragActivity
 * @author xyl
 * @date 2022-11-30
 */
class TransFragAnimActivity : AppCompatActivity() {

    private lateinit var mBinding: AnimActivityTransFragBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = AnimActivityTransFragBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.transFragToolbar.apply {
            toolbarTitle.text = getString(R.string.anim_frag_trans)
            toolbarBackFl.setOnClickListener {
                finish()
            }
        }

        mBinding.transFragBtnReplaceOne.setOnClickListener {
            replaceOneFragment(AnimTransOneFragment())
        }

        mBinding.transFragBtnReplaceTwo.setOnClickListener {
            replaceTwoFragment(AnimTransTwoFragment())
        }

        replaceTwoFragment(AnimTransOneFragment())
    }

    private fun replaceOneFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.trans_frag_container, fragment).commit()
    }

    private fun replaceTwoFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.in_from_right, R.anim.out_to_left)
            .replace(R.id.trans_frag_container, fragment).commit()
    }
}