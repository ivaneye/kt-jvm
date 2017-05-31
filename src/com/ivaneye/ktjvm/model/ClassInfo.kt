package com.ivaneye.ktjvm.model

import com.ivaneye.ktjvm.extern.toPositiveInt
import com.ivaneye.ktjvm.model.attr.Attribute
import com.ivaneye.ktjvm.model.constant.Constant
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
    lateinit var cpInfos: Map<Int, Constant>   //constant包中的对象
    lateinit var accessFlags: U2
    lateinit var thisClass: U2
    lateinit var superClass: U2
    lateinit var interfacesCount: U2
    var interfaceInfos: Array<U2> = emptyArray()   // 常量池中的索引
    lateinit var fieldsCount: U2
    var fieldInfos: Array<FieldInfo> = emptyArray()
    lateinit var methodsCount: U2
    var methodInfos: Array<MethodInfo> = emptyArray()
    lateinit var attributesCount: U2
    var attributeInfos: Array<Attribute> = emptyArray()

    fun magic(): String {
        return "0x${magic.toHexString()}"
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

    fun cpInfos(): Map<Int, Constant> {
        return cpInfos
    }

    fun accessFlags(): String {
        return accessFlags.toHexString()
    }

    fun thisClass(): Int {
        return thisClass.toInt()
    }

    fun superClass(): Int {
        return superClass.toInt()
    }

    fun interfacesCount(): Int {
        return interfacesCount.toInt()
    }

    fun interfaces(): Array<U2> {
        return interfaceInfos;
    }

    fun fieldsCount(): Int {
        return fieldsCount.toInt()
    }

    fun fields(): Array<FieldInfo> {
        return fieldInfos
    }

    fun methodsCount(): Int {
        return methodsCount.toInt()
    }

    fun methods(): Array<MethodInfo> {
        return methodInfos
    }

    fun attributesCount(): Int {
        return attributesCount.toInt()
    }

    fun attributeInfos(): Array<Attribute> {
        return attributeInfos
    }
}
