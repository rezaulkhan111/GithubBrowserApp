package com.machinecode.github_project.data.repository

import android.content.SharedPreferences
import com.google.gson.Gson
import com.machinecode.github_project.data.manager.FetchLocalDataImpl
import com.machinecode.github_project.data.manager.FetchNetworkDataImpl
import com.machinecode.github_project.data.manager.NetworkHelper
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
@Singleton
open class GithubRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val networkDataImpl: FetchNetworkDataImpl,
    private val localDataImpl: FetchLocalDataImpl
) : NetworkHelper {

    fun storeAnyDataPreferences(dataTypeName: String, customerObject: Any) {
        val savePreferences = sharedPreferences.edit()
        savePreferences.putString(dataTypeName, Gson().toJson(customerObject).toString())
        savePreferences.apply()
    }

    fun getAnyObjectFromSharedPreferences(dataName: String, customerObject: Any): Any? {
        val gson = Gson()
        val json = sharedPreferences.getString(dataName, "{}").toString()
        return try {
            gson.fromJson(json, customerObject::class.java)
        } catch (exception: Throwable) {
            gson.toJson(customerObject.javaClass)
        }
    }

    override suspend fun fetchLoginUser(authorization: String) =
        networkDataImpl.fetchLoginUser(authorization)

    override fun fetchSearchRepositories(
        authorization: String,
        queryParam: HashMap<String, Any>
    ) = networkDataImpl.fetchSearchRepositories(authorization, queryParam)
}