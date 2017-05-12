package com.ivaneye.ktjvm.reader

import java.io.InputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipFile

/**
 * Created by wangyifan on 2017/5/11.
 */


class JarFinder(val jarPath: String):Finder {
    override fun readClass(className: String): ByteArray? {
        val zipFile = ZipFile(jarPath)
        for(e in zipFile.entries()){
            if(e.name.contains(className)){
                return zipFile.getInputStream(e).use { it.readBytes() }
            }
        }
        return null
    }

}