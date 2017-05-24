package com.ivaneye.ktjvm.model.attr

import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/24.
 */
class ExceptionTable {

    lateinit var startPc: U2
    lateinit var endPc: U2
    lateinit var handlerPc: U2
    lateinit var cacheType: U2
}