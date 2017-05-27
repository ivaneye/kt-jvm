package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U4

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantFloat(val tag: U1, val bytes: U4, val classInfo: ClassInfo) : Constant {
    override fun type(): String {
        return "Float"
    }

    override fun value(): String {
        val bits = bytes.toInt()
        val s = if (bits.shr(31) == 0) 1 else -1
        val e = bits.shr(23) and 0xff
        val m = if (e == 0) (bits.and(0x7fffff).shl(1)) else (bits.and(0x7fffff).or(0x800000))
        val result = s * m * Math.pow(2.toDouble(), (e - 150).toDouble())
        return "${result}f"
    }

    override fun toString(): String {
        return "${type()}    ${value()}"
    }
}