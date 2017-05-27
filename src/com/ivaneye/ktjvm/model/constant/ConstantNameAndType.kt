package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantNameAndType(val tag: U1, val nameIndex: U2, val descIndex: U2, val classInfo: ClassInfo) : Constant {
    override fun type(): String {
        return "NameAndType"
    }

    override fun value(): String {
        return "\"${classInfo.cpInfos[nameIndex.toInt()]!!.value()}\":${classInfo.cpInfos[descIndex.toInt()]!!.value()}"
    }

    override fun toString(): String {
        return "${type()}    #${nameIndex.toInt()}:#${descIndex.toInt()}    // ${value()}"
    }
}