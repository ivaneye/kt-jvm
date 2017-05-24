package com.ivaneye.ktjvm.model.attr

import com.ivaneye.ktjvm.type.U2
import com.ivaneye.ktjvm.type.U4

/**
 * Created by wangyifan on 2017/5/22.
 */
class RuntimeInvisibleAnnotations : Attribute {

    lateinit var attributeNameIndex: U2
    lateinit var attributeLength: U4
    lateinit var numAnnotation: U2
    lateinit var annotations:Array<AnnotationInfo>
}