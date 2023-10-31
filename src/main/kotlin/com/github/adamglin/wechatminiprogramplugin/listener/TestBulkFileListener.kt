package com.github.adamglin.wechatminiprogramplugin.listener

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.vfs.newvfs.BulkFileListener
import com.intellij.openapi.vfs.newvfs.events.VFileEvent

class TestBulkFileListener : BulkFileListener {
    private val log = Logger.getInstance(TestBulkFileListener::class.java)
    override fun after(events: MutableList<out VFileEvent>) {
        log.error("hello")
        log.error(events.toString())
        super.after(events)
    }
}