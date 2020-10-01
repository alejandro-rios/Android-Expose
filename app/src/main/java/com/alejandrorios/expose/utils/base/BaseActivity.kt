package com.alejandrorios.expose.utils.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author alejandrorios on 8/15/20
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun prepareActivityBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prepareActivityBuilder()
    }
}
