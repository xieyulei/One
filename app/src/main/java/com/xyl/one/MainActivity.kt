package com.xyl.one

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xyl.one.animation.AnimationActivity
import com.xyl.one.databinding.ActivityMainBinding
import com.xyl.one.jetpack.JetpackActivity
import com.xyl.one.widgets.WidgetsActivity
import repository.MainBean
import repository.getMainList

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * MainActivity:主页面
 * @author xieyulei
 * @date 2022-11-25
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.mainRv.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = MainRvAdapter(this@MainActivity, getMainList())
        }
    }

    /**
     * 自定义适配器
     */
    class MainRvAdapter(val context: Context, val data: MutableList<MainBean>) : RecyclerView.Adapter<MainRvAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val icon: ImageView = view.findViewById(R.id.main_rv_item_icon)
            val title: TextView = view.findViewById(R.id.main_rv_item_title)
        }

        // 创建ViewHolder实例
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.main_rv_item, parent, false)
            val viewHolder = ViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                val position = viewHolder.bindingAdapterPosition
                onClick(data, position)
            }
            return viewHolder
        }

        // 用于对RecyclerView子项的数据进行赋值，会在每个子项滚动到屏幕内的时候执行，通过position得到当前项的实例
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = data[position]
            holder.icon.setImageResource(item.imageId)
            holder.title.text = item.title
        }

        // 返回RecyclerView子项的数量，即数据源的长度
        override fun getItemCount(): Int = data.size

        // 处理子项点击事件
        private fun onClick(data: MutableList<MainBean>, position: Int) {
            when (data[position].title) {
                getString(R.string.main_widgets) -> startActivity<WidgetsActivity>(context)
                getString(R.string.main_animation) -> startActivity<AnimationActivity>(context)
                getString(R.string.main_jetpack) -> startActivity<JetpackActivity>(context)
            }
        }
    }
}