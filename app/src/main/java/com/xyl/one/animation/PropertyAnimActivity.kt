package com.xyl.one.animation

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.xyl.one.animation.evaluator.ColorEvaluator
import com.xyl.one.databinding.ActivityPropertyAnimBinding

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * PropertyAnimActivity
 * @author xieyulei
 * @date 2022-11-30
 *
 * 参照文章：https://carsonho.blog.csdn.net/article/details/72909894
 *
 * 简介：属性动画可作用于任意Java对象，即不再局限于视图View对象，可自定义各种动画效果，及不再局限于4中基本变换（平移、旋转、缩放、透明度）
 *
 * 工作原理：在一定时间间隔内，通过不断对值进行改变、不断将该值赋给对象的属性（任意对象的任意属性），从而实现该对象在该属性上的动画效果。
 *
 * 使用核心点：
 *      方法类：ValueAnimator 与 ObjectAnimator
 *      辅助使用类：插值器 & 估值器
 *
 * ValueAnimator与ObjectAnimator的区别：
 *      ValueAnimator类：不断改变值，然后[手动]赋值给对象的属性从而实现动画效果，是间接对对象属性进行操作
 *      ObjectAnimator类：不断改变值，然后[自动]赋值给对象的属性从而实现动画效果，是直接对对象属性进行操作
 *      因此，ObjectAnimator类的使用更加智能、自动化程度更高。
 */
class PropertyAnimActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityPropertyAnimBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPropertyAnimBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnPropertyOfInt.setOnClickListener {
            // ofInt(startValue,endValue),即初始值，结束值
            // ofFloat的用法与ofInt用法差不多，但是值的类型为float
            ValueAnimator.ofInt(mBinding.tvNumber.layoutParams.width, 600).apply {
                // 设置动画运行时长
                duration = 3000

                // 设置更新监听器
                addUpdateListener {
                    // 获得每次变化的属性值
                    val currentValue = it.animatedValue

                    // 每次值变化时，将值手动赋值给对象的属性(即每次变化后的值赋给按钮的宽度，这样就实现了按钮宽度属性的动态变化)
                    mBinding.tvNumber.layoutParams.width = currentValue as Int

                    // 刷新视图，即重新绘制，从而实现动画效果
                    mBinding.tvNumber.requestLayout()
                }
            }.start()
        }

        mBinding.btnPropertyOfObject.setOnClickListener {
            // 属性动画--ObjectAnimator [ https://carsonho.blog.csdn.net/article/details/99712272 ]
            // 属性动画--插值器、估值器
            ObjectAnimator.ofObject(mBinding.colorCircleView, "color", ColorEvaluator(), "#0000FF0", "#FF0000").apply {
                duration = 3000
            }.start()
        }


        mBinding.btnPropertyOfTrans.setOnClickListener {
//            ObjectAnimator.ofFloat(mBinding.tvNumber, "translationX",
//                mBinding.colorCircleView.translationX, 300f, mBinding.tvNumber.translationX).apply {
//                duration = 3000
//            }.start()

//            ObjectAnimator.ofFloat(mBinding.tvNumber, "rotation", 0f, 360f).apply {
//                duration = 3000
//            }.start()
//
//            ObjectAnimator.ofFloat(mBinding.tvNumber, "scaleX", 1f, 3f, 1f).apply {
//                duration = 3000
//            }.start()

            ObjectAnimator.ofFloat(mBinding.tvNumber, "alpha", 1f, 0f, 1f).apply {
                duration = 3000
            }.start()
        }

        /***
         * 手动设置对象属性的set/get方法
         *
         * 直接法：通过继承原始类，直接给类加上该属性的get、set方法
         * 间接法：通过包装原始动画对象，间接给对象加上该属性的get/set方法，即用一个类来包装原始对象
         * https://carsonho.blog.csdn.net/article/details/99712272#t12   【案例来源于：第5特别说明】
         * 当该对象本身无这个属性时，一般采用使用第一种方式，例如View的setWidth比
         */
        mBinding.btnPropertyManualOfObject.setOnClickListener {
            // 属性动画--ObjectAnimator [ https://carsonho.blog.csdn.net/article/details/99712272 ]
            // 属性动画--插值器、估值器
            ObjectAnimator.ofInt(ViewWrapper(mBinding.tvNumber), "width", 1000).apply {
                duration = 3000
            }.start()
        }
    }

    inner class ViewWrapper(private val targetView: View) {
        fun getWidth(): Int {
            return targetView.layoutParams.width
        }

        fun setWidth(width: Int) {
            targetView.layoutParams.width = width
            targetView.requestLayout()
        }
    }


    data class Point(val x: Float, val y: Float)
}