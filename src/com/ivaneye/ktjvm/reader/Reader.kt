package com.ivaneye.ktjvm.reader

/**
 * Created by wangyifan on 2017/5/10.
 */
interface Reader {
    /**
     * 从指定路径读取类内容，返回字节数组
     */
    fun read(classPath: String, className: String): Array<Byte>;
}