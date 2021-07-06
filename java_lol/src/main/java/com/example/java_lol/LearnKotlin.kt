package com.example.java_lol

import java.sql.DriverManager.println

/**
 * @desc 作用描述
 * @author hello word
 * @date 2021/7/1
 */
class LearnKotlin(var name: String) {
    fun greet(){
        println("hello,$name")
    }
}

fun main(args:Array<String>) {
    //var a = 10;
    //println("hello world!")
    LearnKotlin("World!").greet()
}