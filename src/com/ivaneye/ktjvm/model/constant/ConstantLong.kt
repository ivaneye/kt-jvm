package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U4
import com.ivaneye.ktjvm.type.U8

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantLong(val tag: U1, val highBytes: U4, val lowBytes: U4, val classInfo: ClassInfo) : Constant {
    override fun type(): String {
        return "Long"
    }

    override fun value(): String {
        return "${U8(highBytes.toByteArray(), lowBytes.toByteArray()).toLong()}L"
    }

    override fun toString(): String {
        return "${type()}    ${value()}"
    }
}