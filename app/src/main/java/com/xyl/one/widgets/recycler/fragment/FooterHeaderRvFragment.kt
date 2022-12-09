package com.xyl.one.widgets.recycler.fragment

import android.animation.Animator
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.base.BaseRecyclerFragment
import com.xyl.one.data.RvItemBean
import com.xyl.one.data.getFooterHeaderList
import com.xyl.one.databinding.RecyclerFragmentFooterHeaderBinding
import com.xyl.one.databinding.RvItemFooterBinding
import com.xyl.one.databinding.RvItemHeaderPlusBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * FooterHeaderFragment
 * @author xyl
 * @date 2022-12-07
 */
class FooterHeaderRvFragment : BaseRecyclerFragment<RecyclerFragmentFooterHeaderBinding>() {

    private lateinit var mFooterHeaderAdapter: FooterHeaderAdapter

    companion object {
        private const val DELETE = 1
    }

    override fun inflateViewBinding(inflater: LayoutInflater): RecyclerFragmentFooterHeaderBinding {
        return RecyclerFragmentFooterHeaderBinding.inflate(inflater)
    }

    override fun setupToolbar() {
        mBinding.footerHeaderToolbar.apply {
            toolbarTitle.text = getString(R.string.recycler_footer_header)
            toolbarBackFl.setOnClickListener {
                goBack()
            }
        }
    }

    override fun initView() {
        mFooterHeaderAdapter = FooterHeaderAdapter(R.layout.recycler_rv_item, getFooterHeaderList())
        mBinding.footerHeaderRv.apply {
            layoutManager = LinearLayoutManager(requireContext())

            // 添加列表子项分隔线
            val decoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.rv_divider_line)
            drawable?.let {
                decoration.setDrawable(it)
            }
            addItemDecoration(decoration)

            adapter = mFooterHeaderAdapter
        }

        mFooterHeaderAdapter.apply {

            // addFooterView可以设置view的位置，设定在列表中的位置，setFootView默认在最后一个,header也是如此
            setHeaderView(getHeaderView(0) {
                Toast.makeText(requireContext(), "Click Header", Toast.LENGTH_SHORT).show()
                addHeaderView(getHeaderView(1, getRemoveHeaderListener()), 0)
            })

            // addFooter
            val footerBinding = RvItemFooterBinding.inflate(layoutInflater)
            setFooterView(footerBinding.root)
            footerBinding.rvItemLayout.setOnClickListener {
                data.add(RvItemBean("RvItemBean_Add", R.drawable.ic_add))
                notifyItemInserted(this.data.size)
                Toast.makeText(requireContext(), "Click Footer", Toast.LENGTH_SHORT).show()
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
                Toast.makeText(requireContext(), "Item click = $position}", Toast.LENGTH_SHORT).show()
            }

            // Item子元素点击事件
            setOnItemChildClickListener { adapter, _, position ->
                Toast.makeText(
                    requireContext(),
                    "Child click = $position, name = ${(adapter.data[position] as RvItemBean).title}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            // Item的长按事件
            setOnItemLongClickListener { _, _, position ->
                Toast.makeText(requireContext(), "Long click = $position", Toast.LENGTH_SHORT).show()
                true // 这里的true和false影响点击事件向下传递，false时，onItemChildListener也会响应
            }
        }
    }

    class FooterHeaderAdapter(@LayoutRes layoutRes: Int, data: MutableList<RvItemBean>? = null) :
        BaseQuickAdapter<RvItemBean, BaseViewHolder>(layoutRes, data) {
        override fun convert(holder: BaseViewHolder, item: RvItemBean) {
            holder.setText(R.id.recycler_rv_item_title, item.title).setImageResource(R.id.recycler_rv_item_iv, item.imageId)
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
                rvItemHeaderPlusTitle.text = getString(R.string.recycler_text_delete)
                rvItemHeaderPlusIv.setImageResource(R.drawable.ic_delete)
            }
            rvItemLayout.setOnClickListener(listener)
        }
        return headerBinding.root
    }

    private fun getRemoveHeaderListener(): View.OnClickListener {
        return View.OnClickListener { v -> mFooterHeaderAdapter.removeHeaderView(v) }
    }
}