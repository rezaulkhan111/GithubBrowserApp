package com.machinecode.github_project.ui.callback

import com.machinecode.github_project.data.model.RepositoryModel
/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
interface RepositoryCallback {
    fun repositoryItemClick(repositoryModel: RepositoryModel, position: Int)
}