package com.github.adamglin.wechatminiprogramplugin.lang.wxml

import com.github.adamglin.wechatminiprogramplugin.utils.ResourceUtils
import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonObject
import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.xml.XmlTag
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

@Service(Service.Level.PROJECT)
class WXMLMetadata(private val project: Project) {
    @OptIn(ExperimentalSerializationApi::class)
    private val elementDescriptions by lazy {
        ResourceUtils.get("wxml", "attribute-descriptions.json")
            ?.inputStream
            ?.let {
                Json.decodeFromStream<List<WXMLElementDescription>>(it)
            } ?: emptyList()
    }

    companion object {
        fun getElementDescriptions(project: Project): List<WXMLElementDescription> {
            return project.getService(WXMLMetadata::class.java).elementDescriptions
        }

        fun findElementDescription(xmlTag: XmlTag): WXMLElementDescription? {
            val tagName = xmlTag.name
            return this.getElementDescriptions(xmlTag.project).find {
                it.name == tagName
            }
        }

        fun findAttributeDescription(xmlTag: XmlTag, attributeName: String): WXMLAttributeDescription? {
            return this.findElementDescription(xmlTag)?.let { wxmlElementDescription ->
                wxmlElementDescription.attributeDescriptorPresetElementAttributeDescriptors.find {
                    it.key == attributeName
                }
            }
        }
    }
}

