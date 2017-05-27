package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U4

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantInteger(val tag: U1, val bytes: U4, val classInfo: ClassInfo) : Constant {
    override fun type(): String {
        return "Integer"
    }

    override fun value(): String {
        return "${bytes.toInt()})"
    }

    override fun toString(): String {
        return "${type()}    ${value()}"
    }
}