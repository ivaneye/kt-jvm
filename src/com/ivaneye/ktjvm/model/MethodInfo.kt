package com.ivaneye.ktjvm.model

import com.ivaneye.ktjvm.model.attr.Attribute
import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/17.
 */
class MethodInfo(val accFlag: U2, val nameIdx: U2, val descIdx: U2, val attrCount: U2, val attrs: Array<Attribute>, val classInfo: ClassInfo) {

    override fun toString(): String {
        var str = ""
        for(attr in attrs){
            str += attr.toString()
        }
        return "MethodInfo(accFlag=${accFlag.toHexString()},name=${classInfo.cpInfos[nameIdx.toInt()]!!.value()}," +
                "desc=${classInfo.cpInfos[descIdx.toInt()]!!.value()},attrCount=${attrCount.toInt()
                },attrs=[$str])"
    }
}