package com.ivaneye.ktjvm.type

import com.ivaneye.ktjvm.extern.toPositiveLong

/**
 * Created by wangyifan on 2017/5/19.
 */
class U8(val data: ByteArray) {

    fun toLong(): Long {
        return data[0].toPositiveLong().shl(56) + data[1].toPositiveLong().shl(48) +
                data[2].toPositiveLong().shl(40) + data[3].toPositiveLong().shl(32) +
                data[4].toPositiveLong().shl(24) + data[5].toPositiveLong().shl(16) +
                data[6].toPositiveLong().shl(8) + data[7].toPositiveLong()
    }
}