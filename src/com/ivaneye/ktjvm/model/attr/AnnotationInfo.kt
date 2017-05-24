package com.ivaneye.ktjvm.model.attr

import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/24.
 */
class AnnotationInfo {

    lateinit var typeIndex:U2
    lateinit var numElementValuePairs:U2
    lateinit var elementValuePairs:Array<ElementValuePairInfo>
}