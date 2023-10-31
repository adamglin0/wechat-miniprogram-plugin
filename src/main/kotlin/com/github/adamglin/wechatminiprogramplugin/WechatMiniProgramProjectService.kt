package com.github.adamglin.wechatminiprogramplugin

import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
class WechatMiniProgramProjectService(project: Project) : Disposable {
    private final val logger = Logger.getInstance(WechatMiniProgramProjectService::class.java)

    init {
        // avoid any heavy initializations
        logger.debug("WechatMiniProgramService init")
    }


    override fun dispose() {
        logger.debug("WechatMiniProgramService dispose")
    }

}