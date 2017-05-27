package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantMethodRef(val tag: U1, val classIndex: U2, val nameAndTypeIndex: U2, val classInfo: ClassInfo) : Constant {
    override fun type(): String {
        return "Method"
    }

    override fun value(): String {
        val clzIdx = classIndex.toInt()
        val nameIdx = nameAndTypeIndex.toInt()
        val clzVal = classInfo.cpInfos[clzIdx]!!.value()
        val nameVal = classInfo.cpInfos[nameIdx]!!.value()
        return "$clzVal.$nameVal"
    }

    override fun toString(): String {
        val clzIdx = classIndex.toInt()
        val nameIdx = nameAndTypeIndex.toInt()
        return "${type()}    #$clzIdx.#$nameIdx    // ${value()}"
    }
}