package com.xyl.one.widgets.recycler.provider

import android.view.View
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xyl.one.R
import com.xyl.one.data.DataServer
import com.xyl.one.utils.showToast

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * TextProvider
 * @author xyl
 * @date 2022-12-14
 */
class TextProvider(override val itemViewType: Int = DataServer.ITEM_TYPE_TEXT, override val layoutId: Int = R.layout.recycler_text_style_item) :
    BaseItemProvider<DataServer.ProviderMultipleEntity>() {

    override fun convert(helper: BaseViewHolder, item: DataServer.ProviderMultipleEntity) {
        helper.setText(R.id.rv_more_style_tv_item_title, item.content)
        helper.setText(R.id.rv_more_style_tv_item_sub_title, item.subContent)
    }

    override fun onClick(helper: BaseViewHolder, view: View, data: DataServer.ProviderMultipleEntity, position: Int) {
        data.content.showToast()
    }

    override fun onChildLongClick(helper: BaseViewHolder, view: View, data: DataServer.ProviderMultipleEntity, position: Int): Boolean {
        data.content.showToast()
        return true
    }
}