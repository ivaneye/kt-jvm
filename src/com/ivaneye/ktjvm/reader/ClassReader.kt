package com.ivaneye.ktjvm.reader

import com.ivaneye.ktjvm.extern.toPositiveInt
import com.ivaneye.ktjvm.model.ClassInfo

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

}