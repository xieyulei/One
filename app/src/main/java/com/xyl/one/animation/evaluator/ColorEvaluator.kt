package com.xyl.one.animation.evaluator

import android.animation.TypeEvaluator
import kotlin.math.abs

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * ColorEvaluator
 * @author xieyulei
 * @date 2022-12-01
 */
class ColorEvaluator : TypeEvaluator<Any> {

    private var mCurrentRed: Int = 0
    private var mCurrentGreen: Int = 0
    private var mCurrentBlue: Int = 0

    override fun evaluate(fraction: Float, startValue: Any?, endValue: Any?): Any {

        // 获取到颜色的初始值和结束值
        val startColor = startValue as String
        val endColor = endValue as String

        // 通过字符串截取的方式，将初始化的颜色分为RGB三个部分，并将RGB的值转换成十进制数字，那么每个颜色的取值范围就是0~255
        val startRed = Integer.parseInt(startColor.substring(1, 3), 16)
        val startGreen = Integer.parseInt(startColor.substring(3, 5), 16)
        val startBlue = Integer.parseInt(startColor.substring(5, 7), 16)

        val endRed = Integer.parseInt(endColor.substring(1, 3), 16)
        val endGreen = Integer.parseInt(endColor.substring(3, 5), 16)
        val endBlue = Integer.parseInt(endColor.substring(5, 7), 16)

        // 将初始化颜色的值定义为当前需要操作的颜色值
        mCurrentRed = startRed
        mCurrentGreen = startGreen
        mCurrentBlue = startBlue

        // 计算初始颜色和结束颜色之间的差值，该差值决定颜色变化的快慢，初始颜色值和结束颜色值很相近，那么颜色变化就会比较缓慢，否则，变化则很快
        // 具体如何根据差值来决定颜色变化快慢的逻辑写在getCurrentColor()里
        val redDiff = abs(startRed - endRed)
        val greenDiff = abs(startGreen - endGreen)
        val blueDiff = abs(startBlue - endBlue)
        val colorDiff = redDiff + greenDiff + blueDiff

        if (mCurrentRed != endRed) {
            mCurrentRed = getCurrentColor(startRed, endRed, colorDiff, 0, fraction)
        } else if (mCurrentGreen != endGreen) {
            mCurrentGreen = getCurrentColor(startGreen, endGreen, colorDiff, redDiff, fraction)
        } else if (mCurrentBlue != endBlue) {
            mCurrentBlue = getCurrentColor(startBlue, endBlue, colorDiff, redDiff + greenDiff, fraction)
        }
        // 将计算出的当前颜色的值组装返回,由于我们计算出的颜色是十进制数字，所以需要转换成十六进制字符串：调用getHexString方法，最终将RGB颜色拼装起来，并作为最终的结果返回
        return "#${getHexString(mCurrentRed)}${getHexString(mCurrentGreen)}${getHexString(mCurrentBlue)}"
    }

    /**
     * 具体是根据fraction值来计算当前的颜色
     */
    private fun getCurrentColor(startColor: Int, endColor: Int, colorDiff: Int, offset: Int, fraction: Float): Int {
        var currentColor: Int
        if (startColor > endColor) {
            currentColor = (startColor - (fraction * colorDiff - offset)).toInt()
            if (currentColor < endColor) {
                currentColor = endColor
            }
        } else {
            currentColor = (startColor + (fraction * colorDiff - offset)).toInt()
            if (currentColor > endColor) {
                currentColor = endColor
            }
        }
        return currentColor
    }

    /**
     * 将十进制颜色值转换成十六机制
     */
    private fun getHexString(value: Int): String {
        var hexString = Integer.toHexString(value)
        if (hexString.length == 1) {
            hexString = "0$hexString"
        }
        return hexString
    }
}