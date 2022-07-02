package com.machinecode.github_project.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.machinecode.github_project.data.model.RepositoryModel
import kotlinx.coroutines.flow.Flow

@Dao
interface RepositoryDao {
    @Insert
    suspend fun insertRepository(repositoryModel: RepositoryModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepositories(repositoryModels: MutableList<RepositoryModel>)

    @Query("SELECT * FROM RepositoryModel")
    fun getAllLDRepositories(): Flow<MutableList<RepositoryModel>>

    @Query("SELECT * FROM RepositoryModel")
    fun getAllRepositories(): MutableList<RepositoryModel>

    @Query("DELETE FROM RepositoryModel")
    suspend fun deleteAllRepositories()

    @Query("SELECT * FROM RepositoryModel WHERE id=:repositoryId")
    fun getAllLDRepositoriesByCategory(repositoryId: Int): Flow<MutableList<RepositoryModel>>

    @Query("SELECT * FROM RepositoryModel WHERE id=:repositoryId")
    fun getLDRepositoryById(repositoryId: Int): Flow<RepositoryModel>

//    @Query("SELECT * FROM Repository ry INNER JOIN Owner oer ON ry.ownerId=oer.id WHERE ry.id=:repositoryId")
//    fun getLDRepositoryDetailsById(repositoryId: Int): Flow<RepositoryModel>
}