package com.ivaneye.ktjvm

/**
 * Created by wangyifan on 2017/5/5.
 */
object Main {

    val version: String = "0.0.1"

    @JvmStatic fun main(args: Array<String>) {
        when (args[0]) {
            "-version" -> println("Version:$version")
            "-help" -> println("Usage: java [-options] class [args...]")
            else -> startJVM(args)
        }
    }

    private fun startJVM(args: Array<String>) {
        println("classpath:${args[1]} class:${args[2]} args:${args.slice(3..args.size-1)}")
    }
}