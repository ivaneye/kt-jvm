package com.ivaneye.ktjvm.model.attr

import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/24.
 */
class ArrayValueInfo {

    lateinit var numValues:U2
    lateinit var values:Array<ElementValue>
}