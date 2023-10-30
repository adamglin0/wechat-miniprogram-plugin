@file:Suppress("unused")

package com.github.adamglin.wechatminiprogramplugin.lang.wxml

import com.github.adamglin.wechatminiprogramplugin.utils.AnySerializer
import kotlinx.serialization.Polymorphic
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Polymorphic
open class WXMLAttributeDescription(
    val key: String,
    val types: Array<ValueType> = emptyArray(),
    @Serializable(with = AnySerializer::class)
    val default: Any? = null,
    val required: Boolean = false,
    val enums: Array<String> = emptyArray(),
    val requiredInEnums: Boolean = true,
    val description: String? = null,
) {
    enum class ValueType {
        STRING, NUMBER, BOOLEAN,
        COLOR, ARRAY, OBJECT
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

//        other as WXMLPresetAttributeDescription

//        return key == other.key
        return true
    }

    override fun hashCode(): Int {
        return key.hashCode()
    }

    companion object {
        val common = arrayOf(
            WXMLAttributeDescription("id", arrayOf(ValueType.STRING)),
            WXMLAttributeDescription("class", arrayOf(ValueType.STRING)),
            WXMLAttributeDescription("style", arrayOf(ValueType.STRING)),
            WXMLAttributeDescription("hidden", arrayOf(ValueType.BOOLEAN), false),
            WXMLAttributeDescription("slot", arrayOf(ValueType.STRING))
        )
    }
}