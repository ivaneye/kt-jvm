package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U4
import com.ivaneye.ktjvm.type.U8

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantDouble(val tag: U1, val highBytes: U4, val lowBytes: U4, val classInfo: ClassInfo) : Constant {
    override fun type(): String {
        return "Double"
    }

    override fun value(): String {
        val bits = U8(highBytes.toByteArray(), lowBytes.toByteArray()).toLong()
        val s = if (bits.shr(63) == 0L) 1 else -1
        val e = bits.shr(52) and 0x7ffL
        val m = if (e == 0L) (bits.and(0xfffffffffffff).shl(1)) else (bits.and(0xfffffffffffff).or(0x10000000000000L))
        val result = s * m * Math.pow(2.toDouble(), (e - 1075).toDouble())
        return "${result}d"
    }

    override fun toString(): String {
        return "${type()}    ${value()}"
    }
}