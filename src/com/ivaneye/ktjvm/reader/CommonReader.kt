package com.ivaneye.ktjvm.reader

import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2
import com.ivaneye.ktjvm.type.U4
import com.ivaneye.ktjvm.type.U8

/**
 * Created by wangyifan on 2017/5/17.
 */
class CommonReader(var data: ByteArray) {

    fun readU1(): U1 {
        val result = U1(data[0])
        data = data.drop(1).toByteArray()
        return result
    }

    fun readU2(): U2 {
        return U2(readByteArray(2))
    }

    fun readU4(): U4 {
        return U4(readByteArray(4))
    }

    fun readU8(): U8 {
        return U8(readByteArray(8))
    }

    fun readByteArray(size: Int): ByteArray {
        val result = data.sliceArray(IntRange(0, size - 1))
        data = data.drop(size).toByteArray()
        return result
    }
}