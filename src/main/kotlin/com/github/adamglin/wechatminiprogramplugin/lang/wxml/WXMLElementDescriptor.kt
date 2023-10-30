package com.github.adamglin.wechatminiprogramplugin.lang.wxml
class WXMLElementDescriptor(
    val wxmlElementDescription: WXMLElementDescription
) : WXMLBasicElementDescriptor() {

    override fun getDefaultValue(): String? {
        return null
    }

    override fun getName(context: PsiElement?): String {
        return this.name
    }

    override fun getName(): String {
        return wxmlElementDescription.name
    }

    override fun getElementsDescriptors(context: XmlTag): Array<XmlElementDescriptor> {
        return emptyArray()
    }

    override fun init(p0: PsiElement?) {

    }

    override fun getContentType(): Int {
        return XmlElementDescriptor.CONTENT_TYPE_ANY
    }

    override fun getTopGroup(): XmlElementsGroup? {
        return null
    }

    override fun getDefaultName(): String {
        return this.name
    }

    override fun getNSDescriptor(): XmlNSDescriptor? {
        return null
    }

    override fun getQualifiedName(): String {
        return this.name
    }

    override fun getDeclaration(): PsiElement? {
        return this.wxmlElementDescription.definedElement
    }

    override fun getAttributeDescriptor(attributeName: String, context: XmlTag?): XmlAttributeDescriptor? {
        return super.getAttributeDescriptor(attributeName, context)
            ?: this.wxmlElementDescription.attributeDescriptorPresetElementAttributeDescriptors.find {
                it.key == attributeName
            }?.let {
                WXMLAttributeDescriptor(it)
            } ?: AnyXmlAttributeDescriptor(attributeName)
    }

}