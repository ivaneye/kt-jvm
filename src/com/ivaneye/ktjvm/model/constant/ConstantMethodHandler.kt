package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.model.ClassInfo
import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantMethodHandler(val tag: U1, val refKind: U1, val refIndex: U2, val classInfo: ClassInfo) : Constant {
    override fun type(): String {
        throw UnsupportedOperationException()
    }

    override fun value(): String {
        throw UnsupportedOperationException()
    }
}