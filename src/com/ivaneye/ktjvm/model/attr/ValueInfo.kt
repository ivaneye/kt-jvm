package com.ivaneye.ktjvm.model.attr

import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/24.
 */
class ValueInfo {

    lateinit var constValueIndex:U2
    lateinit var enumConstValue:EnumConstValueInfo
    lateinit var classInfoIndex:U2
    lateinit var annotationValue:AnnotationInfo
    lateinit var arrayValue:ArrayValueInfo
}