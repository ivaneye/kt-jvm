package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantInvokeDynamic(val tag: U1, val bootstrapMethodAttrIndex: U2, val nameAndTypeIndex: U2) : Constant {
}