package com.github.adamglin.wechatminiprogramplugin.lang.wxml

import com.intellij.lang.xml.XMLLanguage

object WXMLLanguage : XMLLanguage(INSTANCE, "WXML") {
    private fun readResolve(): Any = WXMLLanguage

//    @JvmStatic
    var EVENT_ATTRIBUTE_PREFIX_ARRAY = arrayOf("bind", "catch", "bind:", "catch:", "mut-bind", "mut-bind:")

//    @JvmStatic
    var INSTANCE = WXMLLanguage
}