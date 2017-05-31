package com.ivaneye.ktjvm.type

import com.ivaneye.ktjvm.extern.toPositiveInt

/**
 * Created by wangyifan on 2017/5/19.
 */
class U1(val data: Byte) {

    fun toInt(): Int {
        return data.toPositiveInt()
    }

    fun toHexString(): String {
        return Integer.toHexString(data.toPositiveInt()).toUpperCase()
    }
}