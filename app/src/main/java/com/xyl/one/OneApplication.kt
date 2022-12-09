package com.xyl.one

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * OneApplication
 * @author xyl
 * @date 2022-12-06
 */
class OneApplication : Application() {

    @SuppressLint("StaticFieldLeak")
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}