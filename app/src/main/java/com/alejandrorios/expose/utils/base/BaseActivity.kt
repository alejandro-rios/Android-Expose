package com.alejandrorios.expose.utils.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author alejandrorios on 8/15/20
 */
abstract class BaseActivity(layout: Int) : AppCompatActivity(layout) {

    abstract fun prepareActivityBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prepareActivityBuilder()
    }
}
