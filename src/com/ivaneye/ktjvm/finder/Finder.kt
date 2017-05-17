package com.ivaneye.ktjvm.finder

/**
 * Created by wangyifan on 2017/5/10.
 */
interface Finder {
    /**
     * 从指定路径读取类内容，返回字节数组
     */
    fun readClass(className: String): ByteArray?
}