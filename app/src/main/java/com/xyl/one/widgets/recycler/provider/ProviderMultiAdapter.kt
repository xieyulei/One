package com.xyl.one.widgets.recycler.provider

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.xyl.one.data.DataServer
import com.xyl.one.data.DataServer.ProviderMultipleEntity

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * ProviderMultiAdapter
 * @author xyl
 * @date 2022-12-14
 */
class ProviderMultiAdapter(data: MutableList<ProviderMultipleEntity>) : BaseProviderMultiAdapter<ProviderMultipleEntity>(data) {

    init {
        addItemProvider(TextProvider())
        addItemProvider(ImageItemProvider())
        addItemProvider(ImgTextItemProvider())
    }

    override fun getItemType(data: List<ProviderMultipleEntity>, position: Int): Int {

        return when (position % 3) {
            0 -> {
                DataServer.ITEM_TYPE_TEXT
            }
            1 -> {
                DataServer.ITEM_TYPE_IMAGE
            }
            2 -> {
                DataServer.ITEM_TYPE_IMAGE_TEXT
            }
            else -> {
                DataServer.ITEM_TYPE_TEXT
            }
        }
    }
}