package com.machinecode.github_project.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
class RepositoryResponse {
    @SerializedName("total_count")
    @Expose
    private var totalCount: Int? = null

    @SerializedName("incomplete_results")
    @Expose
    private var incompleteResults: Boolean? = null

    @SerializedName("items")
    @Expose
    private var items: MutableList<RepositoryModel>? = null

    fun getTotalCount(): Int? {
        return totalCount
    }

    fun setTotalCount(totalCount: Int) {
        this.totalCount = totalCount
    }

    fun getIncompleteResults(): Boolean? {
        return incompleteResults
    }

    fun setIncompleteResults(incompleteResults: Boolean) {
        this.incompleteResults = incompleteResults
    }

    fun getItems(): MutableList<RepositoryModel>? {
        return items
    }

    fun setItems(items: MutableList<RepositoryModel>) {
        this.items = items
    }
}