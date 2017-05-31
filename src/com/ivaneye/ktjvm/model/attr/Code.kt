package com.ivaneye.ktjvm.model.attr

import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2
import com.ivaneye.ktjvm.type.U4
import java.util.*

/**
 * Created by wangyifan on 2017/5/22.
 */
class Code : Attribute {

    lateinit var attributeNameIndex: U2
    lateinit var attributeLength: U4
    lateinit var maxStack: U2
    lateinit var maxLocals: U2
    lateinit var codeLength: U4
    lateinit var code: Array<U1>
    lateinit var exceptionTableLength: U2
    lateinit var exceptionTable: Array<ExceptionTable>
    lateinit var attributesCount: U2
    lateinit var attributes: Array<Attribute>

    override fun toString(): String{
        var str = ""
        for(c in code){
            str += "${c.toHexString()} "
        }
        return "Code(code=${str})"
    }
}