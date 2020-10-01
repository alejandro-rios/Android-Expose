package com.alejandrorios.expose

import android.app.Application
import android.content.Context
import com.alejandrorios.expose.di.AppComponent
import com.alejandrorios.expose.di.DaggerAppComponent

/**
 * @author alejandrorios on 8/15/20
 */
class AndroidExposeApplication : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        setupDagger()
    }

    private fun setupDagger() {
        component = DaggerAppComponent.builder().application(this).build()
        component.inject(this)
    }

    fun getAppComponent(context: Context): AppComponent {
        return (context.applicationContext as AndroidExposeApplication).component
    }

    companion object {
        lateinit var instance: AndroidExposeApplication private set
    }
}
