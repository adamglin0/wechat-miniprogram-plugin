package com.github.adamglin.wechatminiprogramplugin.utils

import com.github.adamglin.wechatminiprogramplugin.lang.wxml.WXMLAttributeDescription

/**
 * [WXMLAttributeDescription.ValueType.NUMBER],[WXMLAttributeDescription.ValueType.ARRAY]
 * And [WXMLAttributeDescription.ValueType.OBJECT] are js type value.
 */
fun WXMLAttributeDescription.isJsTypeAttribute(): Boolean {
    return this.types.let {
        WXMLAttributeDescription.ValueType.NUMBER in it
                || WXMLAttributeDescription.ValueType.ARRAY in it
                || WXMLAttributeDescription.ValueType.OBJECT in it
    }
}