package com.ivaneye.ktjvm.finder

/**
 * Created by wangyifan on 2017/5/11.
 */
class ClassPath {

    lateinit var bootClassPathFinder: Finder
    //bootClassPath���Ѽ���
    lateinit var extClassPathFinder: Finder
    lateinit var userClassPathFinder: Finder

    constructor(cpStr: String) {
        parseBootAndExtClasspath()
        parseUserClasspath(cpStr)
    }

    private fun parseBootAndExtClasspath() {
        val javaHome = System.getenv().filter { "JAVA_HOME".equals(it.key) }["JAVA_HOME"] ?: throw RuntimeException("Can not find JAVA_HOME")
        val jreLibPath = "$javaHome/jre/lib"
        val jreExtPath = "$javaHome/jre/lib/ext"
        bootClassPathFinder = DirFinder(jreLibPath)
        extClassPathFinder = DirFinder(jreExtPath)
    }

    private fun parseUserClasspath(cpStr: String) {
        userClassPathFinder = DirFinder(cpStr)
    }

    fun readClass(className: String): ByteArray? {
        try {
            var result = bootClassPathFinder.readClass(className)
            if (result == null) {
                result = extClassPathFinder.readClass(className)
            }
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
