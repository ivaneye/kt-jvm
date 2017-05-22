package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U4

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantLong(val tag: U1, val highBytes: U4, val lowBytes: U4) : Constant {
}