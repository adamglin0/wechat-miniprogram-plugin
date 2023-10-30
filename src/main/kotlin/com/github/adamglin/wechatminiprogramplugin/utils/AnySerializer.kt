package com.github.adamglin.wechatminiprogramplugin.utils

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object AnySerializer : KSerializer<Any?> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Any", PrimitiveKind.STRING)

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: Any?) {
        when (value) {
            null -> encoder.encodeNull()
            is String -> encoder.encodeString(value)
            is Boolean -> encoder.encodeBoolean(value)
            is Int -> encoder.encodeInt(value)
            else -> throw SerializationException("Unsupported type")
        }
    }

    override fun deserialize(decoder: Decoder): Any? {
        return when (val type = decoder.decodeString()) {
            "null" -> null
            "true", "false" -> type.toBoolean()
            else -> type.toIntOrNull() ?: type
        }
    }
}