package uz.itschool.mathkidsnew

import android.content.Context

class MySharedPreferences private constructor(context: Context){
    private val shared = context.getSharedPreferences("data", 0)
    private val edit = shared.edit()

    companion object{
        private var instance: MySharedPreferences? = null
        fun getInstance(context: Context): MySharedPreferences{
            if (instance == null){
                instance = MySharedPreferences(context)
            }
            return instance!!
        }
    }

    fun getData(level: String): Int{
        return shared.getInt(level, 0)
    }

    fun setData(level: String, score: Int){
        edit.putInt(level, score).apply()
    }
}