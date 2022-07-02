package com.machinecode.github_project.data.remote


/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */

sealed class Resource<T>(
    val status: Status,
    val data: T,
    val error: Throwable? = null
) {
    class Success<T>(data: T) : Resource<T>(Status.SUCCESS, data, null)
    class Loading<T>(data: T) : Resource<T>(Status.LOADING, data, null)
    class Error<T>(throwable: Throwable, data: T) : Resource<T>(Status.ERROR, data, throwable)
}