package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantString(val tag: U1, val strIndex: U2, val classInfo: ClassInfo) : Constant {
    override fun type(): String {
        return "String"
    }

    override fun value(): String {
        val strIdx = strIndex.toInt()
        val strVal = classInfo.cpInfos[strIdx]!!.value()
        return "$strVal"
    }

    override fun toString(): String {
        val strIdx = strIndex.toInt()
        return "${type()}    #$strIdx    // ${value()}"
    }
}