package com.machinecode.github_project.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.machinecode.github_project.data.local.dao.OwnerDao
import com.machinecode.github_project.data.local.dao.RepositoryDao
import com.machinecode.github_project.data.model.OwnerModel
import com.machinecode.github_project.data.model.RepositoryModel

/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
@Database(
    entities = [
        RepositoryModel::class,
        OwnerModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun repositoryDao(): RepositoryDao
    abstract fun ownerDao(): OwnerDao
}