package com.ivaneye.ktjvm.reader

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.model.FieldInfo
import com.ivaneye.ktjvm.model.MethodInfo
import com.ivaneye.ktjvm.model.attr.*
import com.ivaneye.ktjvm.model.constant.*
import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2
import com.ivaneye.ktjvm.type.U4
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
        val cpInfoMap = HashMap<Int, Constant>()
        var i = 1
        while (i < classInfo.constantPoolCount()) {
            val tag = commonReader.readU1()
            when (tag.toInt()) {
                1 -> {
                    val length = commonReader.readU2()
                    cpInfoMap.put(i, ConstantUtf8(tag, length, commonReader.readByteArray(length.toInt()), classInfo))
                }
                3 -> {
                    cpInfoMap.put(i, ConstantInteger(tag, commonReader.readU4(), classInfo))
                }
                4 -> {
                    cpInfoMap.put(i, ConstantFloat(tag, commonReader.readU4(), classInfo))
                }
                5 -> {
                    cpInfoMap.put(i, ConstantLong(tag, commonReader.readU4(), commonReader.readU4(), classInfo))
                    i += 1
                }
                6 -> {
                    cpInfoMap.put(i, ConstantDouble(tag, commonReader.readU4(), commonReader.readU4(), classInfo))
                    i += 1
                }
                7 -> {
                    cpInfoMap.put(i, ConstantClass(tag, commonReader.readU2(), classInfo))
                }
                8 -> {
                    cpInfoMap.put(i, ConstantString(tag, commonReader.readU2(), classInfo))
                }
                9 -> {
                    cpInfoMap.put(i, ConstantFieldRef(tag, commonReader.readU2(), commonReader.readU2(), classInfo))
                }
                10 -> {
                    cpInfoMap.put(i, ConstantMethodRef(tag, commonReader.readU2(), commonReader.readU2(), classInfo))
                }
                11 -> {
                    cpInfoMap.put(i, ConstantInterfaceMethodRef(tag, commonReader.readU2(), commonReader.readU2(), classInfo))
                }
                12 -> {
                    cpInfoMap.put(i, ConstantNameAndType(tag, commonReader.readU2(), commonReader.readU2(), classInfo))
                }
                15 -> {
                    cpInfoMap.put(i, ConstantMethodHandler(tag, commonReader.readU1(), commonReader.readU2(), classInfo))
                }
                16 -> {
                    cpInfoMap.put(i, ConstantMethodType(tag, commonReader.readU2(), classInfo))
                }
                18 -> {
                    cpInfoMap.put(i, ConstantInvokeDynamic(tag, commonReader.readU2(), commonReader.readU2(), classInfo))
                }
            }
            i += 1
        }
        classInfo.cpInfos = cpInfoMap
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
        val count = classInfo.interfacesCount.toInt()
        if (count > 0) {
            val arr = ArrayList<U2>()
            for (i in IntRange(0, count - 1)) {
                arr.add(commonReader.readU2())
            }
            classInfo.interfaceInfos = arr.toTypedArray()
        }
    }

    private fun readFieldCount() {
        classInfo.fieldsCount = commonReader.readU2()
    }

    private fun readFields() {
        val count = classInfo.fieldsCount.toInt()
        if (count > 0) {
            val arr = ArrayList<FieldInfo>()
            for (i in IntRange(0, count - 1)) {
                val accFlag = commonReader.readU2()
                val nameIdx = commonReader.readU2()
                val descIdx = commonReader.readU2()
                val attrCount = commonReader.readU2()
                val attrs = readAttributes(attrCount.toInt())
                val fieldInfo = FieldInfo(accFlag, nameIdx, descIdx, attrCount, attrs, classInfo)
                arr.add(fieldInfo)
            }
            classInfo.fieldInfos = arr.toTypedArray()
        }
    }

    private fun readMethodCount() {
        classInfo.methodsCount = commonReader.readU2()
    }

    private fun readMethods() {
        val count = classInfo.methodsCount.toInt()
        if (count > 0) {
            val arr = ArrayList<MethodInfo>()
            for (i in IntRange(0, count - 1)) {
                val accFlag = commonReader.readU2()
                val nameIdx = commonReader.readU2()
                val descIdx = commonReader.readU2()
                val attrCount = commonReader.readU2()
                val attrs = readAttributes(attrCount.toInt())
                val methodInfo = MethodInfo(accFlag, nameIdx, descIdx, attrCount, attrs, classInfo)
                arr.add(methodInfo)
            }
            classInfo.methodInfos = arr.toTypedArray()
        }
    }

    private fun readAttributesCount() {
        classInfo.attributesCount = commonReader.readU2()
    }

    private fun readAttributes() {
        val count = classInfo.attributesCount.toInt()
        classInfo.attributeInfos = readAttributes(count)
    }

    private fun readAttributes(count: Int): Array<Attribute> {
        if (count > 0) {
            val arr = ArrayList<Attribute>()
            for (i in IntRange(0, count - 1)) {
                val attributeNameIndex = commonReader.readU2()
                val name = classInfo.cpInfos[attributeNameIndex.toInt()]!!.value()
                when (name) {
                    "ConstantValue" -> {
                        val attr = ConstantValue()
                        attr.attributeNameIndex = attributeNameIndex
                        attr.attributeLength = commonReader.readU4()
                        attr.constantValueIndex = commonReader.readU2()
                        attr.classInfo = classInfo
                        arr.add(attr)
                    }
                    "Code" -> {
                        val attr = Code()
                        attr.attributeNameIndex = attributeNameIndex
                        attr.attributeLength = commonReader.readU4()
                        attr.maxStack = commonReader.readU2()
                        attr.maxLocals = commonReader.readU2()
                        attr.codeLength = commonReader.readU4()
                        //解析code
                        val codeArr = ArrayList<U1>()
                        for (i in IntRange(0, attr.codeLength.toInt() - 1)) {
                            codeArr.add(commonReader.readU1())
                        }
                        attr.code = codeArr.toTypedArray()
                        attr.exceptionTableLength = commonReader.readU2()
                        //解析exceptionTable
                        val exceptionArr = ArrayList<ExceptionTable>()
                        for (i in IntRange(0, attr.exceptionTableLength.toInt() - 1)) {
                            val exceptionTable = ExceptionTable()
                            exceptionTable.startPc = commonReader.readU2()
                            exceptionTable.endPc = commonReader.readU2()
                            exceptionTable.handlerPc = commonReader.readU2()
                            exceptionTable.cacheType = commonReader.readU2()
                            exceptionArr.add(exceptionTable)
                        }
                        attr.exceptionTable = exceptionArr.toTypedArray()
                        attr.attributesCount = commonReader.readU2()
                        attr.attributes = readAttributes(attr.attributesCount.toInt())
                        arr.add(attr)
                    }
                    "LineNumberTable" -> {
                        val attr = LineNumberTable()
                        attr.attributeNameIndex = attributeNameIndex
                        attr.attributeLength = commonReader.readU4()
                        attr.lineNumberTableLength = commonReader.readU2()
                        //解析lineNumberInfo
                        val lineNumberInfoArr = ArrayList<LineNumberInfo>()
                        for (i in IntRange(0, attr.lineNumberTableLength.toInt() - 1)) {
                            val lineNumberInfo = LineNumberInfo()
                            lineNumberInfo.startPc = commonReader.readU2()
                            lineNumberInfo.lineNumber = commonReader.readU2()
                            lineNumberInfoArr.add(lineNumberInfo)
                        }
                        attr.lineNumberTable = lineNumberInfoArr.toTypedArray()
                        arr.add(attr)
                    }
                    "LocalVariableTable" -> {
                        val attr = LocalVariableTable()
                        attr.attributeNameIndex = attributeNameIndex
                        attr.attributeLength = commonReader.readU4()
                        attr.localVariableTableLength = commonReader.readU2()
                        //解析LocalVariableInfo
                        val localVariableInfoArr = ArrayList<LocalVariableInfo>()
                        for (i in IntRange(0, attr.localVariableTableLength.toInt() - 1)) {
                            val localVariableInfo = LocalVariableInfo()
                            localVariableInfo.startPc = commonReader.readU2()
                            localVariableInfo.length = commonReader.readU2()
                            localVariableInfo.nameIndex = commonReader.readU2()
                            localVariableInfo.descriptorIndex = commonReader.readU2()
                            localVariableInfo.index = commonReader.readU2()
                            localVariableInfoArr.add(localVariableInfo)
                        }
                        attr.localVariableTable = localVariableInfoArr.toTypedArray()
                        arr.add(attr)
                    }
                    "SourceFile" -> {
                        val attr = SourceFile()
                        attr.attributeNameIndex = attributeNameIndex
                        attr.attributeLength = commonReader.readU4()
                        attr.sourceFileIndex = commonReader.readU2()
                        arr.add(attr)
                    }
                    else -> {
                        println("Attr $name not support!Will Ignore!")
                        commonReader.drop(commonReader.readU4().toInt())
                    }
                }
            }
            return arr.toTypedArray()
        }
        return ArrayList<Attribute>().toTypedArray()
    }
}