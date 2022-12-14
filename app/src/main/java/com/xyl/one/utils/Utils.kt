package com.xyl.one.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.xyl.one.OneApplication

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * Utils
 * @author xyl
 * @date 2022-12-06
 */

/**
 * 权限修饰符
 *  public 默认，所有类可见
 *  private 当前类可见
 *  protect 当前类、子类可见
 *  inner 同一模块中的类可见
 */

/**
 * 根据资源ID返回资源字符串
 */
fun getString(resId: Int): String = OneApplication.context.getString(resId)

/**
 * Toast
 */
fun String.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(OneApplication.context, this, duration).show()
}

fun Int.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(OneApplication.context, this, duration).show()
}

/**
 * Activity跳转启动不带参数
 * 用法：startActivity<TestActivity>(context)
 */
inline fun <reified T> startActivity(context: Context) {
    val intent = Intent(context, T::class.java)
    context.startActivity(intent)
}

/**
 * Activity跳转启动带参数
 *
 * 用法：startActivity<TestActivity>(context){
 *          putExtra("param1","data")
 *          putExtra("param2",123)
 *      }
 */
inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
    val intent = Intent(context, T::class.java)
    intent.block()
    context.startActivity(intent)
}
