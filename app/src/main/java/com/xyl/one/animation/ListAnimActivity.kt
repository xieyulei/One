package com.xyl.one.animation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xyl.one.R
import com.xyl.one.databinding.ActivityListAnimBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * ListAnimActivity
 * @author xieyulei
 * @date 2022-11-30
 */
class ListAnimActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityListAnimBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityListAnimBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = RecyclerAdapter(getFruitList())
        mBinding.listRv.layoutManager = LinearLayoutManager(this)

        // 为RecyclerView的item添加动画（此处为代码方式添加），另一种方式是在xml中，为recyclerView添加android:layoutAnimation属性
        // xml中使用属性添加动画 和 下面使用代码添加，两者同样的效果，关键点在于item里边的动画组合
//        val animation = AnimationUtils.loadAnimation(this, R.anim.item_anim)
//        val controller = LayoutAnimationController(animation).apply {
//            delay = 0.5f
//            order = LayoutAnimationController.ORDER_NORMAL
//        }
//        mBinding.listRv.layoutAnimation = controller

        mBinding.listRv.adapter = adapter
    }

    class RecyclerAdapter(private val fruitList: List<Fruit>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val fruitImage: ImageView = view.findViewById(R.id.rv_item_iv)
            val fruitName: TextView = view.findViewById(R.id.rv_item_tv)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int = fruitList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val fruit = fruitList[position]
            holder.fruitImage.setImageResource(fruit.imageId)
            holder.fruitName.text = fruit.name
        }
    }

    data class Fruit(val name: String, val imageId: Int)

    private fun getFruitList(): List<Fruit> {
        val list = mutableListOf<Fruit>()
        repeat(10) {
            list.add(Fruit(getString(R.string.main_animation), R.mipmap.ic_launcher))
        }
        return list
    }
}