package com.machinecode.github_project.data.manager
/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
interface NetworkHelper {
    suspend fun fetchLoginUser(authorization: String): Any

    fun fetchSearchRepositories(
        authorization: String,
        queryParam: HashMap<String, Any>
    ): Any
}