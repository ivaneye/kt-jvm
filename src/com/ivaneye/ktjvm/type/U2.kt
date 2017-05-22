package com.ivaneye.ktjvm.type

import com.ivaneye.ktjvm.extern.toPositiveInt

/**
 * Created by wangyifan on 2017/5/19.
 */
class U2(val data: ByteArray) {

    fun toInt(): Int {
        return data[0].toPositiveInt().shl(8) + data[1].toPositiveInt()
    }

    fun toHexString(): String {
        var str = ""
        for (i in data) {
            str += Integer.toHexString(i.toPositiveInt()).toUpperCase()
        }
        return str
    }
}