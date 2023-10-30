package com.github.adamglin.wechatminiprogramplugin.utils

import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.ResourceUtil

object ResourceUtils {
    fun get(basePath: String, fileName: String): VirtualFile? {
        return VfsUtil.findFileByURL(
            ResourceUtil.getResource(
                ResourceUtils.javaClass.classLoader,
                basePath,
                fileName
            )
        )
    }
}
