package com.machinecode.github_project.data.remote

import com.machinecode.github_project.data.model.LoginResponse
import com.machinecode.github_project.data.model.RepositoryResponse
import retrofit2.http.*
/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
interface ApiService {
    @Headers("Content-Type: application/json")
    @GET("users/{login}")
    suspend fun fetchLoginUser(@Path("login") authorization: String): LoginResponse

    @Headers("Content-Type: application/json")
    @GET("search/repositories")
    suspend fun fetchSearchRepositories(
        @QueryMap queryParam: HashMap<String, Any>
    ): RepositoryResponse
}