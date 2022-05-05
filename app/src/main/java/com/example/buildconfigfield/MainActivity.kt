package com.example.buildconfigfield

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.buildconfigfield.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        val stringBuffer = StringBuffer("buildConfigField: \n\n")

        stringBuffer.run {
            append("defaultConfig:\n")
            append("SHOW_LOG =  ${BuildConfig.SHOW_LOG} \n")
            append("NUMBER =  ${BuildConfig.NUMBER} \n")
            append("NUMBER_LONG =  ${BuildConfig.NUMBER_LONG} \n")
            append("NUMBER_FLOAT =  ${BuildConfig.NUMBER_FLOAT} \n")
            append("APP_KEY = " + BuildConfig.APP_KEY + "\n")
            append("NAME =  ${BuildConfig.NAME} \n")
            append("TOKEN =  ${BuildConfig.TOKEN} \n")
            val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
            val date = Date(BuildConfig.BUILD_DATE)
            append("BUILD_DATE =  ${sdf.format(date)} \n")
            append("\n")

            append("buildTypes:\n")
            append("buildType =  ${BuildConfig.BUILD_TYPE} \n")
            append("\n")

            append("productFlavors:\n")
            append("FLAVOR =  ${BuildConfig.FLAVOR} \n")
            append("\n")
        }

        binding.display.text = stringBuffer.toString()
    }
}