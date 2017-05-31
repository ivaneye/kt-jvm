package com.ivaneye.ktjvm

import com.ivaneye.ktjvm.extern.toPositiveInt
import com.ivaneye.ktjvm.finder.ClassPath
import com.ivaneye.ktjvm.reader.ClassReader
import java.io.File
import java.io.FileInputStream

/**
 * Created by wangyifan on 2017/5/5.
 */
object Main {

    val version: String = "0.0.1"

    @JvmStatic fun main(args: Array<String>) {
        when (args[0]) {
            "-version" -> showVersion()
            "-help" -> showHelp()
            else -> startJVM(args)
        }
    }

    private fun showHelp() = println("Usage: java [-options] class [args...]")

    private fun showVersion() = println("Version:$version")

    private fun startJVM(args: Array<String>) {
        println("classpath:${args[1]} class:${args[2]} args:${args.slice(3..args.size - 1)}")
        val cp = ClassPath(args[1])
        val className = args[2].replace(Regex.fromLiteral("."), "/")
        val classData = cp.readClass(className)
        println("className:$className,classData:$classData")
        val classReader = ClassReader(classData!!)
        val classInfo = classReader.readClass()
        println(classInfo.magic())
        println(classInfo.minorVersion())
        println(classInfo.majorVersion())
        println(classInfo.constantPoolCount())
        println("Constant pool:")
        for((key,value) in classInfo.cpInfos()) {
            println("#$key = $value")
        }
        println("{")
        println(classInfo.accessFlags())
        println(classInfo.thisClass())
        println(classInfo.superClass())
        println(classInfo.interfacesCount())
        println(classInfo.interfaces())
        println(classInfo.fieldsCount())
        println("Fields:")
        for(field in classInfo.fields()) {
            println(field)
        }
        println("Fields End!")
        println(classInfo.methodsCount())
        println("Methods:")
        for(method in classInfo.methods()) {
            println(method)
        }
        println("Methods End!")
        println(classInfo.methods())
        println(classInfo.attributesCount())
        println(classInfo.attributeInfos())
    }
}