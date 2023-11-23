package uz.itschool.mathkidsnew

import kotlin.random.Random
import kotlin.random.nextInt

class MisolMaker private constructor(
    val a: Int,
    val b: Int,
    val c: Int,
    val sign: String
){
    companion object{
        fun generate(level: String): MisolMaker{
            var variable1: Int = 0
            var variable2: Int = 0
            var answer: Int = 0
            var sign: String = ""

            val symbols = mutableListOf<String>("+", "-", "/", "*")
            sign = symbols.random()

            when(level){
                "easy" -> {
                    val nums = getNumbers(11, sign)
                    variable1 = nums[0]
                    variable2 = nums[1]
                }
                "normal" -> {
                    val nums = getNumbers(99, sign)
                    variable1 = nums[0]
                    variable2 = nums[1]
                }
                "hard" -> {
                    val nums = getNumbers(999, sign)
                    variable1 = nums[0]
                    variable2 = nums[1]
                }
            }

            when(sign){
                "+" -> {
                    answer = variable1+variable2
                }
                "-" -> {
                    answer = variable1-variable2
                }
                "*" -> {
                    answer = variable1*variable2
                }
                "/" -> {
                    answer = variable1/variable2
                }
            }

            return MisolMaker(a = variable1, b = variable2, c = answer, sign = sign)
        }

        fun getNumbers(limit: Int, sign: String): MutableList<Int>{
            var a = Random.nextInt(1, limit)
            var b = Random.nextInt(1, limit)
            if (sign=="+" || sign=="*"){
                while (a==2 && b==2){
                    a = Random.nextInt(1, limit)
                    b = Random.nextInt(1, limit)
                }
            }
            if (sign=="/"){
                while ((a%b) != 0){
                    a = Random.nextInt(1, limit)
                    b = Random.nextInt(1, limit)
                }
            }
            return mutableListOf(a, b)
        }
    }
}