package com.gustavo.desafio_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gustavo.desafio_android.ui.main.MainFragment

class MainActivity : AppCompatActivity(R.layout.main_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                    .replace(R.id.container, MainFragment.newInstance())
//                    .commitNow()
//        }
    }
}