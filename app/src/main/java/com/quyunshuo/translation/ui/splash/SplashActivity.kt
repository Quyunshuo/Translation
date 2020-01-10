package com.quyunshuo.translation.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quyunshuo.translation.R
import com.quyunshuo.translation.ui.main.MainActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    private val mMainScope by lazy { MainScope() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mMainScope.launch(Dispatchers.Default) {
            delay(1000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            delay(100)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainScope.cancel()
    }
}
