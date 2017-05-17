package com.ivaneye.ktjvm.reader

import com.ivaneye.ktjvm.extern.toPositiveInt

/**
 * Created by wangyifan on 2017/5/17.
 */
class CommonReader(var data: ByteArray) {

    fun readU1(): Int {
        val result = data[0].toPositiveInt()
        data = data.drop(1).toByteArray()
        return result
    }

    fun readU2(): Int {
        val result = data[0].toPositiveInt().shl(8) + data[1].toPositiveInt()
        data = data.drop(2).toByteArray()
        return result
    }

    fun readU4(): Int {
        val result = data[0].toPositiveInt().shl(24) + data[1].toPositiveInt().shl(16) +
                data[2].toPositiveInt().shl(8) + data[3].toPositiveInt()
        data = data.drop(4).toByteArray()
        return result
    }
}