@file:Suppress("unused")

package com.github.adamglin.wechatminiprogramplugin.lang.wxml

import com.intellij.json.psi.JsonStringLiteral
import kotlinx.serialization.Serializable

@Serializable
data class WXMLElementDescription(
    val name: String,
    val attributeDescriptorPresetElementAttributeDescriptors: Array<WXMLAttributeDescription> = emptyArray(),
    val events: Array<String> = emptyArray(),
    val canOpen: Boolean = true,
    val canClose: Boolean = false,
    val description: String? = null,
    val url: String? = null,
    val definedElement: JsonStringLiteral,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WXMLElementDescription

        if (name != other.name) return false
        if (!attributeDescriptorPresetElementAttributeDescriptors.contentEquals(other.attributeDescriptorPresetElementAttributeDescriptors)) return false
        if (!events.contentEquals(other.events)) return false
        if (canOpen != other.canOpen) return false
        if (canClose != other.canClose) return false
        if (description != other.description) return false
        if (url != other.url) return false
        if (definedElement != other.definedElement) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + attributeDescriptorPresetElementAttributeDescriptors.contentHashCode()
        result = 31 * result + events.contentHashCode()
        result = 31 * result + canOpen.hashCode()
        result = 31 * result + canClose.hashCode()
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + definedElement.hashCode()
        return result
    }

    override fun toString(): String {
        return super.toString()
    }

    companion object {
        @Suppress("SpellCheckingInspection")
        val commonEvent = arrayOf(
            "touchstart", "touchmove", "touchcancel", "touchend", "tap", "longpress", "longtap", "transitionend",
            "animationstart", "animationiteration", "animationend", "touchforcechange"
        )
    }
}

