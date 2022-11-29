package com.xyl.one.learn

import kotlin.math.max

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * KotlinLearn
 * @author xieyulei
 * @date 2022-11-25
 */


fun printLine(str: String = "------------------------------------------------------------") {
    println("******************************$str******************************")
}

fun main() {
    printLine("var 与 val")
    // var:声明可变的变量
    var name = "Sim"
    name = "Smile"
    println(name)

    // val:声明不可变的变量
    val age = 11
    println("age = " + (age + 1))

    printLine("定义函数")
    fun largerNumber(num1: Int, num2: Int): Int {
        return max(num1, num2)
    }
    println("large number is = " + largerNumber(1, 2))

    printLine("逻辑控制")
    fun getScore(name: String) = when (name) {
        "Tome" -> 77
        "Jack" -> 88
        "Lucy" -> 99
        else -> "No find this name"
    }
    println(getScore("Lucy"))
    println(getScore("Jim"))

    printLine("循环语句")
    println("for - in")
    for (i in 0..5) {
        print(i)
    }
    println()
    println("for - until")
    for (i in 0 until 5) {
        print(i)
    }
    println()
    println("for - downTo")
    for (i in 5 downTo 0) {
        print(i)
    }
    println()

    printLine("权限修饰符")
    println("public 默认，所有类可见")
    println("private 当前类可见")
    println("protect 当前类、子类可见")
    println("inner 同一模块中的类可见")


}