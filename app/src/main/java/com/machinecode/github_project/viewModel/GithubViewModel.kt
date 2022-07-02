package com.machinecode.github_project.viewModel

import android.util.Base64
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.machinecode.github_project.data.model.appModel.UserCredentialModel
import com.machinecode.github_project.data.repository.GithubRepositoryImpl
import com.machinecode.github_project.utils.AppConstantUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
@HiltViewModel
class GithubViewModel @Inject constructor(private val gitRepoImpl: GithubRepositoryImpl) :
    ViewModel(), ViewModelHelper {

    private fun storeUserInfo(
        userName: String,
        passWord: String
    ) {
        gitRepoImpl.storeAnyDataPreferences(AppConstantUtils.UserCredentialModel,
            UserCredentialModel()
                .apply {
                    username = userName
                    password = passWord
                })
    }

    private fun getAuthorization(): String {
        val userCredential = gitRepoImpl.getAnyObjectFromSharedPreferences(
            "",
            UserCredentialModel()
        ) as UserCredentialModel
        return "Basic " + Base64.encodeToString(
            "${userCredential.username}:${userCredential.password}".toByteArray(),
            Base64.NO_WRAP
        )
    }

    override fun fetchLoginUser(
        userName: String,
        password: String,
    ) {
        viewModelScope.launch {
            if (userName.isNotEmpty() && password.isNotEmpty()) {
                gitRepoImpl.fetchLoginUser(getAuthorization())
            } else {
                storeUserInfo(userName, password)
                gitRepoImpl.fetchLoginUser(getAuthorization())
            }
        }
    }


    override fun fetchSearchRepositories(
        queryParam: HashMap<String, Any>
    ) = gitRepoImpl.fetchSearchRepositories(getAuthorization(), queryParam).asLiveData()
}