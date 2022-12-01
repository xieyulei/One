package com.xyl.one.animation.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * ColorCircleView
 * @author xieyulei
 * @date 2022-12-01
 */
class ColorCircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    companion object {
        // 圆的半径
        private const val RADIUS = 100f
    }

    private val mPaint = Paint().apply {
        isAntiAlias = true
        color = Color.BLUE
    }

    private var mColor: String = ""

    fun getColor(): String = mColor
    fun setColor(color: String) {
        mColor = color
        mPaint.color = Color.parseColor(color)
        // 调用invalidate方法，即画笔颜色每次改变都会刷新视图，然后调用onDraw方法重新绘制视图
        // 而因为每次调用onDraw方法时画笔的颜色都会改变，所以圆的颜色也会改变，从而实现动画效果
        invalidate()
    }

    /**
     * 复写onDraw从而实现绘制逻辑
     * 绘制逻辑：现在起始点画圆，通过监听当前坐标值(currentPoint)的变化，每次变化都调用onDraw方法重新绘制圆，从而实现圆的平移动画效果
     */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(500f, 500f, RADIUS, mPaint)
    }

}