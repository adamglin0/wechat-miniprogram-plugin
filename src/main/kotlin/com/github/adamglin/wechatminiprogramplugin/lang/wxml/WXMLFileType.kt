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

import com.github.adamglin.wechatminiprogramplugin.icons.WechatMiniProgramIcons
import com.intellij.ide.highlighter.XmlLikeFileType
import javax.swing.Icon

open class WXMLFileType : XmlLikeFileType(WXMLLanguage.INSTANCE) {

    companion object {
        val INSTANCE = WXMLFileType()
    }

    override fun getIcon(): Icon? {
        return WechatMiniProgramIcons.wxml
    }

    override fun getName(): String {
        return "WXML"
    }

    override fun getDefaultExtension(): String {
        return "wxml"
    }

    override fun getDescription(): String {
        return "The markup language similar to HTML used in WeChat Mini Program development"
    }

}