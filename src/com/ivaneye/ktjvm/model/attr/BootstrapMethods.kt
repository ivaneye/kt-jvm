package com.ivaneye.ktjvm.model.attr

import com.ivaneye.ktjvm.type.U2
import com.ivaneye.ktjvm.type.U4

/**
 * Created by wangyifan on 2017/5/22.
 */
class BootstrapMethods : Attribute {

    lateinit var attributeNameIndex: U2
    lateinit var attributeLength: U4
    lateinit var numBootStrapMethods:U2
    lateinit var bootstrapMethods:Array<BootStrapMethodInfo>
}

class BootStrapMethodInfo {

    lateinit var bootstrapMethodRef:U2
    lateinit var numBootstrapArguments:U2
    lateinit var bootstrapArguments:Array<U2>
}