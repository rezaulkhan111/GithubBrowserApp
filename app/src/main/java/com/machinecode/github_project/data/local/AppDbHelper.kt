package com.machinecode.github_project.data.local

import androidx.room.withTransaction
import com.machinecode.github_project.data.model.RepositoryModel
import com.machinecode.github_project.data.model.RepositoryResponse
import com.machinecode.github_project.utils.AppConstant
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
open class AppDbHelper @Inject constructor(private val dataBase: AppDataBase) {

    suspend fun insertSearchRepository(repoRes: RepositoryResponse) {
        dataBase.apply {
            withTransaction {
                repositoryDao().deleteAllRepositories()
                ownerDao().deleteAllOwners()
                for (repoItem in repoRes.getItems()!!) {
                    val tempOwner = repoItem.getOwner()
                    repoItem.setOwnerId(tempOwner!!.getId())

                    repositoryDao().insertRepository(repoItem)
                    ownerDao().insertOwner(repoItem.getOwner()!!)
                }
            }
        }
    }

    fun getALLLDSearchRepository() = dataBase.repositoryDao().getAllLDRepositories()

    fun getALLLDTSearchRepository() = flow {
        emit(RepositoryResponse().apply {
            dataBase.apply {
                withTransaction {
                    val reposTempList = repositoryDao().getAllRepositories()
                    for (reposItem in reposTempList) {
                        reposItem.setOwner(ownerDao().getOwnerById(reposItem.getOwnerId()!!))
                    }
                    setItems(reposTempList)
                }
            }
        })
    }
}