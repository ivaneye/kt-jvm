package com.ivaneye.ktjvm.model.attr

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.type.U2
import com.ivaneye.ktjvm.type.U4

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantValue : Attribute {

    lateinit var attributeNameIndex: U2
    lateinit var attributeLength: U4
    lateinit var constantValueIndex: U2
    lateinit var classInfo: ClassInfo
    override fun toString(): String{
        return "ConstantValue(constantValue=${classInfo.cpInfos[constantValueIndex.toInt()]!!.value()})"
    }


}