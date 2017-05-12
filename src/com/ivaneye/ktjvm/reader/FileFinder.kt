package com.ivaneye.ktjvm.reader

import java.io.File
import java.io.FileInputStream
import java.nio.charset.Charset

/**
 * 从文件路径中读取文件
 * Created by wangyifan on 2017/5/11.
 */
class FileFinder(val libPath: String) : Finder {
    override fun readClass(className: String): ByteArray? {
        if (libPath.replace(Regex.fromLiteral("\\"),"/").contains(className)) {
            return File(libPath).readBytes()
        }
        return null
    }

}