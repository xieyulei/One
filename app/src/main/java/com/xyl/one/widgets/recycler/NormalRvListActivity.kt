package com.xyl.one.widgets.recycler

import android.animation.Animator
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.databinding.ActivityNormalListBinding
import com.xyl.one.databinding.RvItemFooterBinding
import com.xyl.one.databinding.RvItemHeaderPlusBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * NormalRvList
 * @author xieyulei
 * @date 2022-12-03
 */
class NormalRvListActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityNormalListBinding
    private lateinit var mNormalListAdapter: NormalListAdapter

    companion object {
        private const val DELETE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityNormalListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        mNormalListAdapter = NormalListAdapter(R.layout.rv_item, getListData())
        mBinding.normalRv.apply {
            layoutManager = LinearLayoutManager(this@NormalRvListActivity)

            // 添加列表子项分隔线
            val decoration = DividerItemDecoration(this@NormalRvListActivity, LinearLayoutManager.VERTICAL)
            val drawable = ContextCompat.getDrawable(this@NormalRvListActivity, R.drawable.rv_divider_line)
            drawable?.let {
                decoration.setDrawable(it)
            }
            addItemDecoration(decoration)

            adapter = mNormalListAdapter
        }

        mNormalListAdapter.apply {

            // addFooterView可以设置view的位置，设定在列表中的位置，setFootView默认在最后一个,header也是如此
            setHeaderView(getHeaderView(0) {
                Toast.makeText(this@NormalRvListActivity, "Click Header", Toast.LENGTH_SHORT).show()
                addHeaderView(getHeaderView(1, getRemoveHeaderListener()), 0)
            })

            // addFooter
            val footerBinding = RvItemFooterBinding.inflate(layoutInflater)
            setFooterView(footerBinding.root)
            footerBinding.rvItemLayout.setOnClickListener {
                data.add(Fruit("Fruit_Add", R.drawable.ic_add))
                notifyItemInserted(this.data.size)
                Toast.makeText(this@NormalRvListActivity, "Click Footer", Toast.LENGTH_SHORT).show()
            }

            // 是否打开动画,默认false
            animationEnable = true

            // 动画是否仅第一次执行，默认true
            isAnimationFirstOnly = false

            // 使用内置默认动画设置,默认AnimationType.AlphaIn（参照：BaseQuickAdapter.addAnimation()）
            setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInRight)

            // 设置子控件的事件，必须与Adapter绑定，否则点击事件无法生效（因为无法找到你需要设置的控件）
            addChildClickViewIds(R.id.rv_item_iv, R.id.rv_item_iv, R.id.rv_item_layout)
            addChildLongClickViewIds(R.id.rv_item_iv, R.id.rv_item_iv, R.id.rv_item_layout)

            // Item整体点击事件（setOnItemClickListener(object : OnItemClickListener { implement method })）
            setOnItemClickListener { _, _, position ->
                Toast.makeText(this@NormalRvListActivity, "Item click = $position}", Toast.LENGTH_SHORT).show()
            }

            // Item子元素点击事件
            setOnItemChildClickListener { adapter, _, position ->
                Toast.makeText(
                    this@NormalRvListActivity,
                    "Child click = $position, name = ${(adapter.data[position] as Fruit).name}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            // Item的长按事件
            setOnItemLongClickListener { _, _, position ->
                Toast.makeText(this@NormalRvListActivity, "Long click = $position", Toast.LENGTH_SHORT).show()
                true // 这里的true和false影响点击事件向下传递，false时，onItemChildListener也会响应
            }
        }
    }

    class NormalListAdapter(@LayoutRes layoutRes: Int, data: MutableList<Fruit>? = null) : BaseQuickAdapter<Fruit, BaseViewHolder>(layoutRes, data) {
        override fun convert(holder: BaseViewHolder, item: Fruit) {
            holder.setText(R.id.rv_item_tv, item.name).setImageResource(R.id.rv_item_iv, item.imageId)
        }

        /**
         * 由于进入界面的item都是很多的速度进来的所以不会出现滑动显示的依次执行动画效果，这个时候会一起执行动画，如果觉得这样的效果不好可以使用setNotDoAnimationCount设置第一屏item不执行动画，但是如果需要依次执行动画可以重写startAnim让第一个屏幕的item动画延迟执行即可。
         */
        override fun startAnim(anim: Animator, index: Int) {
            super.startAnim(anim, index)
            if (index < data.size) return
            anim.startDelay = index * 150L
        }
    }

    /**
     * 获取将要被添加的header
     */
    private fun getHeaderView(type: Int, listener: View.OnClickListener): View {
        val headerBinding = RvItemHeaderPlusBinding.inflate(layoutInflater).apply {
            if (type == DELETE) {
                rvItemHeaderPlusTitle.text = getString(R.string.recycler_delete_text)
                rvItemHeaderPlusIv.setImageResource(R.drawable.ic_delete)
            }
            rvItemLayout.setOnClickListener(listener)
        }
        return headerBinding.root
    }

    private fun getRemoveHeaderListener(): View.OnClickListener {
        return View.OnClickListener { v -> mNormalListAdapter.removeHeaderView(v) }
    }
}