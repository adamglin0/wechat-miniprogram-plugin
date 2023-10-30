/*
 *     Copyright (c) [2019] [zxy]
 *     [wechat-miniprogram-plugin] is licensed under the Mulan PSL v1.
 *     You can use this software according to the terms and conditions of the Mulan PSL v1.
 *     You may obtain a copy of Mulan PSL v1 at:
 *         http://license.coscl.org.cn/MulanPSL
 *     THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR
 *     IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR
 *     PURPOSE.
 *     See the Mulan PSL v1 for more details.
 */

package com.github.adamglin.wechatminiprogramplugin.lang.wxml

import com.github.adamglin.wechatminiprogramplugin.utils.isJsTypeAttribute
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.source.xml.SchemaPrefix
import com.intellij.psi.xml.XmlTag
import com.intellij.xml.DefaultXmlExtension

class WXMLForXmlExtension : DefaultXmlExtension() {

    companion object {
        // todo
        val selfClosingTagNames = arrayOf("input", "textarea", "image", "icon", "import", "include")
    }

    override fun isAvailable(file: PsiFile): Boolean {
        // available when fileType is WXML.
        return file.fileType == WXMLFileType.INSTANCE
    }

    override fun getAttributeValuePresentation(
        tag: XmlTag?,
        attributeName: String,
        defaultAttributeQuote: String,
    ): AttributeValuePresentation {

        if (tag == null) {
            return super.getAttributeValuePresentation(tag, attributeName, defaultAttributeQuote)
        }

        val attributeDescription = WXMLMetadata.findAttributeDescription(tag, attributeName)
            ?: return super.getAttributeValuePresentation(tag, attributeName, defaultAttributeQuote)

        // if type is number\array\object need add {{}}
        if (attributeDescription.isJsTypeAttribute()) {
            return object : AttributeValuePresentation {
                override fun showAutoPopup(): Boolean {
                    return attributeDescription.enums.isNotEmpty()
                }

                override fun getPostfix(): String {
                    return "}}$defaultAttributeQuote"
                }

                override fun getPrefix(): String {
                    return "$defaultAttributeQuote{{"
                }
            }
        }

        return super.getAttributeValuePresentation(tag, attributeName, defaultAttributeQuote)
    }

    /**
     * default InsertHandler will not be used.
     */
    override fun useXmlTagInsertHandler(): Boolean {
        return false
    }

    /**
     *  some tag can be closed auto.
     */
    override fun isSelfClosingTagAllowed(tag: XmlTag): Boolean {
        return selfClosingTagNames.contains(tag.name)
    }

    override fun getPrefixDeclaration(context: XmlTag, namespacePrefix: String?): SchemaPrefix? {
        if (
            namespacePrefix != null &&
            namespacePrefix in listOf("wx", "bind", "catch", "model", "mark", "mut-bind")
        ) {
            findAttributeSchema(context, namespacePrefix)?.let { return it }
        }
        return super.getPrefixDeclaration(context, namespacePrefix)
    }

    private fun findAttributeSchema(context: XmlTag, namespacePrefix: String): SchemaPrefix? {
        return context.attributes
            .find { it.name.startsWith("$namespacePrefix:") }
            ?.let { SchemaPrefix(it, TextRange.create(0, namespacePrefix.length), namespacePrefix) }
    }


}