//package com.github.adamglin.wechatminiprogramplugin.lang.wxml
//
//import com.intellij.json.psi.JsonProperty
//import com.intellij.psi.impl.source.xml.XmlElementDescriptorProvider
//import com.intellij.psi.xml.XmlTag
//import com.intellij.xml.XmlElementDescriptor
//
///**
// * 提供Wxml小程序自带组件以及自定义组件的标签描述
// */
//class WXMLElementDescriptorProvider : XmlElementDescriptorProvider {
//    override fun getDescriptor(xmlTag: XmlTag): XmlElementDescriptor? {
//        if (xmlTag.language !is WXMLLanguage) {
//            return null
//        }
//        val tagName = xmlTag.name.ifBlank { return null }
//        val jsonProperty = findCustomComponentJsonProperty(xmlTag)
//        if (jsonProperty != null) {
//            return WxmlCustomComponentDescriptor(jsonProperty)
//        }
//        return WXMLMetadata.getElementDescriptions(xmlTag.project).find {
//            it.name == tagName
//        }?.let {
//            WXMLElementDescriptor(
//                it
//            )
//        }
//
//    }
//
//    private fun findCustomComponentJsonProperty(xmlTag: XmlTag): JsonProperty? {
//        val tagName = xmlTag.name
//        val wxmlPsiFile = xmlTag.containingFile
//        val jsonFile = RelateFileHolder.JSON.findFile(wxmlPsiFile.originalFile) as? JsonFile ?: return null
//        // 找到usingComponents的配置
//        val usingComponentItems = mutableListOf<JsonProperty>().apply {
//            ComponentJsonUtils.getUsingComponentItems(jsonFile)?.let {
//                this.addAll(it)
//            }
//            AppJsonUtils.findUsingComponentItems(xmlTag.project)?.let {
//                this.addAll(it)
//            }
//        }
//        return usingComponentItems.find {
//            it.name == tagName
//        }
//    }
//}