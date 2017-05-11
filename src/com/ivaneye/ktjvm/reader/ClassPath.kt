package com.ivaneye.ktjvm.reader

/**
 * Created by wangyifan on 2017/5/11.
 */
class ClassPath {

    lateinit var bootClassPathFinder: Finder
    //bootClassPathÖÐÒÑ¼ÓÔØ
//    lateinit var extClassPathFinder: Finder
    lateinit var userClassPathFinder: Finder

    constructor(cpStr: String) {
        parseBootAndExtClasspath()
        parseUserClasspath(cpStr)
    }

    private fun parseBootAndExtClasspath() {
        val javaHome = System.getenv().filter { e -> "JAVA_HOME".equals(e.key) }["JAVA_HOME"] ?: throw RuntimeException("Can not find JAVA_HOME")
        val jreLibPath = "$javaHome/jre/lib"
        val jreExtPath = "$javaHome/jre/lib/ext"
        bootClassPathFinder = DirFinder(jreLibPath)
//        extClassPathFinder = DirFinder(jreExtPath)
    }

    private fun parseUserClasspath(cpStr: String) {
        userClassPathFinder = DirFinder(cpStr)
    }

    fun readClass(className: String): ByteArray? {
        try {
            var result = bootClassPathFinder.readClass(className)
            if (result == null) {
                result = userClassPathFinder.readClass(className)
            }
            return result
        } catch(e: Exception) {
            e.printStackTrace()
            return null
        }
    }
}
