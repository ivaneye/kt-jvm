package com.ivaneye.ktjvm.model.constant

import com.ivaneye.ktjvm.type.U1
import com.ivaneye.ktjvm.type.U2

/**
 * Created by wangyifan on 2017/5/22.
 */
class ConstantUtf8(val tag: U1, val length: U2, val arr: ByteArray) {
}