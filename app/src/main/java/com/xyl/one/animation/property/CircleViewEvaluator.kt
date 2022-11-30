package com.xyl.one.animation.property

import android.animation.TypeEvaluator
import com.xyl.one.animation.PropertyAnimActivity.Point

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * CircleViewEvaluator:自定义估值器（自定义如何从初始点坐标过渡到结束点坐标）
 * @author xieyulei
 * @date 2022-11-30
 */
class CircleViewEvaluator : TypeEvaluator<Any> {
    override fun evaluate(fraction: Float, startValue: Any?, endValue: Any?): Any {
        // 将动画初始值startValue 和 动画结束值endValue 强制类型转换成Point对象
        val startPoint = startValue as Point
        val endPoint = endValue as Point

        // 根据fraction来计算当前动画的x和y的值
        val x = startPoint.x + 210 + fraction * (endPoint.x) - startPoint.x
        val y = startPoint.y + 210 + fraction * (endPoint.y) - startPoint.y

        // 将计算后的坐标封装到一个新的Point对象中并返回
        return Point(x, y)
    }
}