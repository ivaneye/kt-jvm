package com.ivaneye.ktjvm.model.attr

import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/24.
 */
class ParameterAnnotationInfo {

    lateinit var numAnnotations: U2
    lateinit var annotations: Array<AnnotationInfo>
}