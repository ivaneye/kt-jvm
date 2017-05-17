package com.ivaneye.ktjvm.finder

import java.io.File
import java.io.FileInputStream
import java.nio.charset.Charset

/**
 * ���ļ�·���ж�ȡ�ļ�
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