package repository

import com.xyl.one.R
import com.xyl.one.getString

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * MainRepository:MainActivity页面数据
 * @author xieyulei
 * @date 2022-12-06
 */
data class MainBean(val title: String, val imageId: Int)

fun getMainList(): MutableList<MainBean> {
    return arrayListOf(
        MainBean(getString(R.string.main_widgets), R.drawable.ic_widgets),
        MainBean(getString(R.string.main_animation), R.drawable.ic_animation),
        MainBean(getString(R.string.main_jetpack), R.drawable.ic_jetpack)
    )
}

