package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantMethodType(val tag: U1, val descIndex: U2, val classInfo: ClassInfo) : Constant {
    override fun type(): String {
        return "MethodType"
    }

    override fun value(): String {
        val descIdx = descIndex.toInt()
        val descVal = classInfo.cpInfos[descIdx]!!.value()
        return "$descVal"
    }

    override fun toString(): String {
        val descIdx = descIndex.toInt()
        return "${type()}    #$descIdx    // ${value()}"
    }
}