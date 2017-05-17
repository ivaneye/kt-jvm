package com.ivaneye.ktjvm.model

/**
 * Created by wangyifan on 2017/5/17.
 */
class ClassInfo {
    lateinit var magic: String
    var minorVersion: Int = 0
    var majorVersion: Int = 0
    var constantPoolCount: Int = 0
    lateinit var cpInfos:Array<ConstantPoolInfo>
    var accessFlags: Int = 0
    var thisClass: Int = 0
    var superClass: Int = 0
    var interfacesCount: Int = 0
    lateinit var interfaceInfos:Array<InterfaceInfo>
    var fieldsCount: Int = 0
    lateinit var fieldInfos:Array<FieldInfo>
    var methodsCount: Int = 0
    lateinit var methodInfos:Array<MethodInfo>
    var attributesCount: Int = 0
    lateinit var attributeInfos:Array<AttributeInfo>
}
