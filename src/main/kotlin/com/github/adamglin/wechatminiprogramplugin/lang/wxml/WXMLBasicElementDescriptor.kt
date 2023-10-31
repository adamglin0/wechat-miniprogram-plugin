//package com.github.adamglin.wechatminiprogramplugin.lang.wxml
//
//import com.intellij.psi.impl.source.xml.XmlElementDescriptorProvider
//import com.intellij.psi.xml.XmlTag
//import com.intellij.xml.XmlAttributeDescriptor
//import com.intellij.xml.XmlElementDescriptor
//import com.intellij.xml.XmlElementsGroup
//import com.intellij.xml.XmlNSDescriptor
//
//abstract class WXMLBasicElementDescriptor : XmlElementDescriptor {
//    override fun getContentType(): Int {
//        return XmlElementDescriptor.CONTENT_TYPE_ANY
//    }
//
//    override fun getTopGroup(): XmlElementsGroup? {
//        return null
//    }
//
//    override fun getNSDescriptor(): XmlNSDescriptor? {
//        return null
//    }
//
//    override fun getElementDescriptor(child: XmlTag, context: XmlTag): XmlElementDescriptor? {
//        return XmlElementDescriptorProvider.EP_NAME.findExtension(WXMLElementDescriptorProvider::class.java)
//            ?.getDescriptor(child)
//    }
//
//    override fun getAttributeDescriptor(attributeName: String, context: XmlTag?): XmlAttributeDescriptor? {
//        if (attributeName in WXMLAttributeDescription.common.map { it.key }
//            || WXMLUtils.likeEventAttribute(
//                attributeName
//            )) {
//            // 公共属性或公共事件
//            return AnyXmlAttributeDescriptor(attributeName)
//        }
//        return null
//    }
//
//    override fun getAttributeDescriptor(attribute: XmlAttribute?): XmlAttributeDescriptor? {
//        return this.getAttributeDescriptor(attribute?.name ?: return null, attribute.parent)
//    }
//
//    override fun getAttributesDescriptors(p0: XmlTag?): Array<XmlAttributeDescriptor> {
//        return emptyArray()
//    }
//}