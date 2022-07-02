package com.machinecode.github_project.data.manager

import com.machinecode.github_project.data.local.AppDbHelper
import com.machinecode.github_project.data.remote.ApiService
import com.machinecode.github_project.data.repository.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject
/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
open class FetchNetworkDataImpl @Inject constructor(
    private val apiService: ApiService,
    private val dbHelper: AppDbHelper
) : NetworkHelper {
    override suspend fun fetchLoginUser(authorization: String) =
        apiService.fetchLoginUser(authorization)

    override fun fetchSearchRepositories(
        authorization: String,
        queryParam: HashMap<String, Any>
    ) = networkBoundResource(
        query = {
            dbHelper.getALLLDTSearchRepository()
        },
        fetch = {
            delay(2000)
            apiService.fetchSearchRepositories(queryParam)
        },
        saveFetchResult = {
            dbHelper.insertSearchRepository(it)
        })
}