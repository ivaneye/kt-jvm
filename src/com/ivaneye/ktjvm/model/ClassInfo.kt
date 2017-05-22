package com.ivaneye.ktjvm.model

import com.ivaneye.ktjvm.extern.toPositiveInt
import com.ivaneye.ktjvm.type.U2
import com.ivaneye.ktjvm.type.U4

/**
 * Created by wangyifan on 2017/5/17.
 */
class ClassInfo {
    lateinit var magic: U4
    lateinit var minorVersion: U2
    lateinit var majorVersion: U2
    lateinit var constantPoolCount: U2
    lateinit var cpInfos: Array<Object>   //constant包中的对象
    lateinit var accessFlags: U2
    lateinit var thisClass: U2
    lateinit var superClass: U2
    lateinit var interfacesCount: U2
    lateinit var interfaceInfos: Array<InterfaceInfo>
    lateinit var fieldsCount: U2
    lateinit var fieldInfos: Array<FieldInfo>
    lateinit var methodsCount: U2
    lateinit var methodInfos: Array<MethodInfo>
    lateinit var attributesCount: U2
    lateinit var attributeInfos: Array<AttributeInfo>

    fun magic(): String {
        return magic.toHexString()
    }

    fun minorVersion(): Int {
        return minorVersion.toInt()
    }

    fun majorVersion(): Int {
        return majorVersion.toInt()
    }

    fun constantPoolCount(): Int {
        return constantPoolCount.toInt()
    }
}
