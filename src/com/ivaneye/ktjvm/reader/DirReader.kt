package com.ivaneye.ktjvm.reader

/**
 * 从目录下读取Class文件
 * Created by wangyifan on 2017/5/10.
 */
class DirReader : Reader{
    override fun read(classPath: String, className: String): Array<Byte> {
        val classPath = className.replace("\\.","/")
        throw UnsupportedOperationException()
    }
}