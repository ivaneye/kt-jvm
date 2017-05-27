package com.ivaneye.ktjvm.type

import com.ivaneye.ktjvm.extern.toPositiveLong

/**
 * Created by wangyifan on 2017/5/19.
 */
class U8(val highBytes: ByteArray, val lowBytes: ByteArray) {

    fun toLong(): Long {
        return highBytes[0].toPositiveLong().shl(56) + highBytes[1].toPositiveLong().shl(48) +
                highBytes[2].toPositiveLong().shl(40) + highBytes[3].toPositiveLong().shl(32) +
                lowBytes[0].toPositiveLong().shl(24) + lowBytes[1].toPositiveLong().shl(16) +
                lowBytes[2].toPositiveLong().shl(8) + lowBytes[3].toPositiveLong()
    }
}