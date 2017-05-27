package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantUtf8(val tag: U1, val length: U2, val arr: ByteArray, val classInfo: ClassInfo) : Constant {
    override fun value(): String {
        return String(arr)
    }

    override fun type(): String {
        return "Utf8"
    }

    override fun toString(): String {
        return "Utf8    ${String(arr)}"
    }
}