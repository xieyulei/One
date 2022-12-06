package com.xyl.one

import android.content.Context
import android.content.Intent

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * Utils
 * @author xieyulei
 * @date 2022-12-06
 */


/**
 * 根据资源ID返回资源字符串
 */
fun getString(resId: Int): String = OneApplication.context.getString(resId)

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
