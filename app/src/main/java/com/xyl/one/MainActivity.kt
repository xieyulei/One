package com.xyl.one

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.animation.AnimationActivity
import com.xyl.one.data.RvItemBean
import com.xyl.one.data.getMainList
import com.xyl.one.databinding.ActivityMainBinding
import com.xyl.one.databinding.MainRvHeaderBinding
import com.xyl.one.jetpack.JetpackActivity
import com.xyl.one.utils.startActivity
import com.xyl.one.widgets.WidgetsActivity

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * MainActivity:主页面
 * @author xieyulei
 * @date 2022-11-25
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: MainRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initView()
    }

    private fun initView() {
        mAdapter = MainRvAdapter(R.layout.main_rv_item, getMainList())
        mBinding.mainRv.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = mAdapter
        }
        val header = MainRvHeaderBinding.inflate(layoutInflater)
        mAdapter.setHeaderView(header.root)

        mAdapter.setOnItemClickListener { adapter, _, position ->
            val item = adapter.data[position] as RvItemBean
            when (item.title) {
                com.xyl.one.utils.getString(R.string.main_widgets) -> startActivity<WidgetsActivity>(this)
                com.xyl.one.utils.getString(R.string.main_animation) -> startActivity<AnimationActivity>(this)
                com.xyl.one.utils.getString(R.string.main_jetpack) -> startActivity<JetpackActivity>(this)
            }
        }
    }

    /**
     * 自定义适配器
     */
    class MainRvAdapter(layoutId: Int, data: MutableList<RvItemBean>) :
        BaseQuickAdapter<RvItemBean, BaseViewHolder>(layoutId, data) {

        override fun convert(holder: BaseViewHolder, item: RvItemBean) {
            holder.setText(R.id.main_rv_item_title, item.title)
                .setImageResource(R.id.main_rv_item_icon, item.imageId)
        }
    }
}