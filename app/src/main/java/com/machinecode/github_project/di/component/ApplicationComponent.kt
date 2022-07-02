package com.machinecode.github_project.di.component

import android.content.Context
import com.machinecode.github_project.di.module.LocalDataModule
import com.machinecode.github_project.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
@Singleton
@Component(
    modules = [NetworkModule::class,
        LocalDataModule::class]
)
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}