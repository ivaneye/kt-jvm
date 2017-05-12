package com.ivaneye.ktjvm.extern

/**
 * Created by wangyifan on 2017/5/12.
 */
//转化为无符号整型
fun Byte.toPositiveInt() = toInt() and 0xFF