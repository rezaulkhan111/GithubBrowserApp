package com.machinecode.github_project.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.machinecode.github_project.data.model.OwnerModel
import com.machinecode.github_project.data.model.RepositoryModel
import kotlinx.coroutines.flow.Flow

@Dao
interface OwnerDao {
    @Insert
    suspend fun insertOwner(owner: OwnerModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwners(owners: MutableList<OwnerModel>)

    @Query("SELECT * FROM OwnerModel")
    fun getAllOwners(): MutableList<OwnerModel>

    @Query("SELECT * FROM OwnerModel")
    fun getAllLDOwners(): Flow<MutableList<OwnerModel>>

    @Query("DELETE FROM OwnerModel")
    suspend fun deleteAllOwners()

    @Query("SELECT * FROM OwnerModel WHERE id=:ownerId")
    fun getOwnerById(ownerId: Int): OwnerModel
}