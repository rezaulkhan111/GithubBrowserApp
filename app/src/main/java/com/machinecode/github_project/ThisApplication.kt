package com.machinecode.github_project

import android.app.Application
import com.machinecode.github_project.di.component.ApplicationComponent
import com.machinecode.github_project.di.component.DaggerApplicationComponent
import dagger.hilt.android.HiltAndroidApp

/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
@HiltAndroidApp
class ThisApplication : Application() {
    val applicationComponent: ApplicationComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent(): ApplicationComponent {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }
}