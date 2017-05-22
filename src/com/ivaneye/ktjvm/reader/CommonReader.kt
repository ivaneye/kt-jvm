package com.ivaneye.ktjvm.reader

import com.ivaneye.ktjvm.extern.toPositiveInt
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
        val result = U2(data.sliceArray(IntRange(0, 1)))
        data = data.drop(2).toByteArray()
        return result
    }

    fun readU4(): U4 {
        val result = U4(data.sliceArray(IntRange(0, 3)))
        data = data.drop(4).toByteArray()
        return result
    }

    fun readU8(): U8 {
        val result = U8(data.sliceArray(IntRange(0, 7)))
        data = data.drop(8).toByteArray()
        return result
    }
}