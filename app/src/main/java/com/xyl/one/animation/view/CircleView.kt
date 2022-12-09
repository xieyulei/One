package com.xyl.one.animation.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.xyl.one.animation.evaluator.CircleViewEvaluator
import com.xyl.one.animation.fragment.PropertyAnimFragment.Point

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * CircleView
 * @author xyl
 * @date 2022-11-30
 */
class CircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object {
        private const val RADIUS = 70F
    }

    private var mCurrentPoint: Point? = null

    private val mPaint = Paint().apply {
        isAntiAlias = true
        color = Color.BLUE
    }

    /**
     * 绘制逻辑：现在初始点画圆，通过监听当前坐标值（currentPoint）的变化，每次变化都调用onDraw()重新绘制圆，从而实现圆的平移动画效果
     */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 如果当前点坐标为空(即第一次)
        canvas?.let {
            if (mCurrentPoint == null) {
                mCurrentPoint = Point(RADIUS * 3, RADIUS * 3)

                // 创建一个点对象,坐标是(70,70)
                val x = mCurrentPoint!!.x
                val y = mCurrentPoint!!.y
                canvas.drawCircle(x, y, RADIUS, mPaint)

                // 将属性动画作用到View中
                val startPoint = Point(RADIUS * 3, RADIUS * 3) // 初始点为圆点(70,70)
                val endPoint = Point(700f, 300f) // 结束点为(700,300)

                // 创建动画对象 & 设置初始值和结束值
                ValueAnimator.ofObject(CircleViewEvaluator(), startPoint, endPoint).apply {
                    duration = 3000
                    repeatMode = ValueAnimator.REVERSE
                    repeatCount = 3
                    // 通过值的更新监听器，将改变的对象手动赋值给当前对象，此处是将改变后的坐标值对象赋给当前的坐标值对象
                    // 设置值的更新监听器，即每当坐标值(Point对象)更新一次，该方法就会被调用一次
                    addUpdateListener {
                        // 每次赋值后就重新赋值，从而实现动画效果
                        mCurrentPoint = it.animatedValue as Point?

                        // 调用invalidate后，就会刷新View，即才能看到重新绘制的界面，即onDraw方法会被重新调用一次，所以坐标值没改变一次，就会调用onDraw方法一次
                        invalidate()
                    }
                }.start()
            } else {
                // 如果坐标值不为0，则画圈，所以坐标值没改变一次，就会调用onDraw方法一次，就会画一次圈，从而实现动画效果
                // 在该点画一个圆：圆心=(30,30),半径=30
                mCurrentPoint?.let {
                    val x = it.x
                    val y = it.y
                    canvas.drawCircle(x, y, RADIUS, mPaint)
                }
            }
        }
    }
}