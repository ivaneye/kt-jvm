package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2
import com.ivaneye.ktjvm.type.U4

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantClass(val tag: U1, val nameIndex: U2, val classInfo: ClassInfo) : Constant {
    override fun value(): String {
        return classInfo.cpInfos[nameIndex.toInt()]!!.value()
    }

    override fun type(): String {
        return "Class"
    }

    override fun toString(): String {
        val idx = nameIndex.toInt()
        return "${type()}    #$idx    // ${value()}"
    }
}