package com.ivaneye.ktjvm.cmd

//import com.xenomachina.argparser.
/**
 * Created by wangyifan on 2017/5/8.
 */
class CmdArgs(parser: ArgParser) {
    val verbose by parser.flagging("-v", "--verbose",
            help = "enable verbose mode")

    val name by parser.storing("-w", "--widget-name",
            help = "name of the widget")

    val size by parser.storing("-s", "--size",
            help = "size of the plumbus") { toInt() }
}