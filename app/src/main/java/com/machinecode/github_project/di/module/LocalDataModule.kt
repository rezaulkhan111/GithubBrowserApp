package com.machinecode.github_project.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.machinecode.github_project.data.local.AppDataBase
import com.machinecode.github_project.data.local.AppDbHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
@InstallIn(SingletonComponent::class)
@Module
class LocalDataModule {
    @Provides
    @Singleton
    fun providerSharedPreference(application: Application): SharedPreferences {
        return application.getSharedPreferences("pro", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase =
        Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "githubProject.db"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideAppDbHelper(appDatabase: AppDataBase) = AppDbHelper(appDatabase)
}