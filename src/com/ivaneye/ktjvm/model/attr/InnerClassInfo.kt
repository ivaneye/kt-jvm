package com.ivaneye.ktjvm.model.attr

import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/24.
 */
class InnerClassInfo {

    lateinit var innerClassInfoIndex: U2
    lateinit var outerClassInfoIndex: U2
    lateinit var innerNameIndex: U2
    lateinit var innerClassAccessFlag: U2
}