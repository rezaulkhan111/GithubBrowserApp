package com.machinecode.github_project.viewModel

/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
interface ViewModelHelper {
    fun fetchLoginUser(userName: String, password: String)

    fun fetchSearchRepositories(
        queryParam: HashMap<String, Any>
    ): Any
}