package com.ivaneye.ktjvm.model.attr

import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2
import com.ivaneye.ktjvm.type.U4

/**
 * Created by wangyifan on 2017/5/22.
 */
class RuntimeInvisibleParameterAnnotations : Attribute {

    lateinit var attributeNameIndex: U2
    lateinit var attributeLength: U4
    lateinit var numParameters: U1
    lateinit var parameterAnnotations:Array<ParameterAnnotationInfo>
}