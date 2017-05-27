package com.ivaneye.ktjvm.type

import com.ivaneye.ktjvm.extern.toPositiveInt

/**
 * Created by wangyifan on 2017/5/19.
 */
class U4(val data: ByteArray) {

    fun toInt(): Int {
        return data[0].toPositiveInt().shl(24) + data[1].toPositiveInt().shl(16) +
                data[2].toPositiveInt().shl(8) + data[3].toPositiveInt()
    }

    fun toHexString(): String {
        var str = ""
        for (i in data) {
            str += Integer.toHexString(i.toPositiveInt()).toUpperCase()
        }
        return str
    }

    fun toByteArray(): ByteArray {
        return data
    }
}