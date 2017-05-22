package com.ivaneye.ktjvm.reader

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.model.constant.*
import java.util.*

/**
 * Created by wangyifan on 2017/5/17.
 */
class ClassReader {

    lateinit var commonReader: CommonReader
    lateinit var classInfo: ClassInfo

    constructor(data: ByteArray) {
        commonReader = CommonReader(data)
        classInfo = ClassInfo()
    }

    fun readClass(): ClassInfo {
        readMagic()
        readMinorVersion()
        readMajorVersion()
        readConstantPoolCount()
        readConstantPool()
        readAccessFlag()
        readThisClass()
        readSuperClass()
        readInterfacesCount()
        readInterfaces()
        readFieldCount()
        readFields()
        readMethodCount()
        readMethods()
        readAttributesCount()
        readAttributes()
        return classInfo
    }

    private fun readMagic() {
        classInfo.magic = commonReader.readU4()
    }

    private fun readMinorVersion() {
        classInfo.minorVersion = commonReader.readU2()
    }

    private fun readMajorVersion() {
        classInfo.majorVersion = commonReader.readU2()
    }

    private fun readConstantPoolCount() {
        classInfo.constantPoolCount = commonReader.readU2()
    }

    private fun readConstantPool() {
        //常量池下标从1开始
        val arrList = ArrayList<Constant>(classInfo.constantPoolCount() - 1)
        var i = 1
        while (i < classInfo.constantPoolCount()) {
            val tag = commonReader.readU1()
            i += 1
            when (tag.toInt()) {
                1 -> {
                    val length = commonReader.readU2()
                    arrList.add(ConstantUtf8(tag, length, commonReader.readByteArray(length.toInt())))
                }
                3 -> {
                    arrList.add(ConstantInteger(tag, commonReader.readU4()))
                }
                4 -> {
                    arrList.add(ConstantFloat(tag, commonReader.readU4()))
                }
                5 -> {
                    arrList.add(ConstantLong(tag, commonReader.readU4(), commonReader.readU4()))
                    i += 1
                }
                6 -> {
                    arrList.add(ConstantDouble(tag, commonReader.readU4(), commonReader.readU4()))
                    i += 1
                }
                7 -> {
                    arrList.add(ConstantClass(tag, commonReader.readU2()))
                }
                8 -> {
                    arrList.add(ConstantString(tag, commonReader.readU2()))
                }
                9 -> {
                    arrList.add(ConstantFieldRef(tag, commonReader.readU2(), commonReader.readU2()))
                }
                10 -> {
                    arrList.add(ConstantMethodRef(tag, commonReader.readU2(), commonReader.readU2()))
                }
                11 -> {
                    arrList.add(ConstantInterfaceMethodRef(tag, commonReader.readU2(), commonReader.readU2()))
                }
                12 -> {
                    arrList.add(ConstantNameAndType(tag, commonReader.readU2(), commonReader.readU2()))
                }
                15 -> {
                    arrList.add(ConstantMethodHandler(tag, commonReader.readU1(), commonReader.readU2()))
                }
                16 -> {
                    arrList.add(ConstantMethodType(tag, commonReader.readU2()))
                }
                18 -> {
                    arrList.add(ConstantInvokeDynamic(tag, commonReader.readU2(), commonReader.readU2()))
                }
            }
        }
        classInfo.cpInfos = arrList.toTypedArray()
    }

    private fun readAccessFlag() {
        classInfo.accessFlags = commonReader.readU2()
    }

    private fun readThisClass() {
        classInfo.thisClass = commonReader.readU2()
    }

    private fun readSuperClass() {
        classInfo.superClass = commonReader.readU2()
    }

    private fun readInterfacesCount() {
        classInfo.interfacesCount = commonReader.readU2()
    }

    private fun readInterfaces() {

    }

    private fun readFieldCount() {
        classInfo.fieldsCount = commonReader.readU2()
    }

    private fun readFields() {

    }

    private fun readMethodCount() {
        classInfo.methodsCount = commonReader.readU2()
    }

    private fun readMethods() {

    }

    private fun readAttributesCount() {

    }

    private fun readAttributes() {

    }
}