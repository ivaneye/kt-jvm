package com.ivaneye.ktjvm.reader

import java.io.File
import java.util.*

/**
 * 从目录下读取Class文件
 * Created by wangyifan on 2017/5/10.
 */
class DirFinder : Finder {

    val finders = ArrayList<Finder>()

    constructor(cpStr: String) {
        val dir = File(cpStr)
        val files = dir.walk().filter { file -> file.name.endsWith(".jar") || file.name.endsWith(".class") }
        files.forEach { f ->
            if (f.name.endsWith(".jar")) {
                finders.add(JarFinder(f.absolutePath))
            } else if (f.name.endsWith(".class")) {
                finders.add(FileFinder(f.absolutePath))
            }
        }
    }

    override fun readClass(className: String): ByteArray? {
        for(f in finders){
            var result = f.readClass(className)
            if (result != null) return result;
        }
        return null
    }
}