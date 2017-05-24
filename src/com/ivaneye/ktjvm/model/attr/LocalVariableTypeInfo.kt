package com.ivaneye.ktjvm.model.attr

import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/24.
 */
class LocalVariableTypeInfo {

    lateinit var startPc: U2
    lateinit var length: U2
    lateinit var nameIndex: U2
    lateinit var signatureIndex: U2
    lateinit var index: U2
}