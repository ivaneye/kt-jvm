package com.ivaneye.ktjvm.model

import com.ivaneye.ktjvm.extern.toPositiveInt

/**
 * Created by wangyifan on 2017/5/17.
 */
class ClassInfo {
    var magic: ByteArray = ByteArray(4)
    var minorVersion: ByteArray = ByteArray(2)
    var majorVersion: ByteArray = ByteArray(2)
    var constantPoolCount: ByteArray = ByteArray(2)
    lateinit var cpInfos: Array<ConstantPoolInfo>
    var accessFlags: ByteArray = ByteArray(2)
    var thisClass: ByteArray = ByteArray(2)
    var superClass: ByteArray = ByteArray(2)
    var interfacesCount: ByteArray = ByteArray(2)
    lateinit var interfaceInfos: Array<InterfaceInfo>
    var fieldsCount: ByteArray = ByteArray(2)
    lateinit var fieldInfos: Array<FieldInfo>
    var methodsCount: ByteArray = ByteArray(2)
    lateinit var methodInfos: Array<MethodInfo>
    var attributesCount: ByteArray = ByteArray(2)
    lateinit var attributeInfos: Array<AttributeInfo>

    fun showMagic() {
        var str = "0x"
        for (i in magic) {
            str += Integer.toHexString(i.toPositiveInt()).toUpperCase()
        }
        println(str)
    }
}
