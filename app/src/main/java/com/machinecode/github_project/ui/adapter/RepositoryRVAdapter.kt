package com.machinecode.github_project.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.machinecode.github_project.data.model.RepositoryModel
import com.machinecode.github_project.databinding.RvRepositoryItemBinding
import com.machinecode.github_project.ui.callback.RepositoryCallback
import com.machinecode.github_project.ui.common.BaseViewHolder
import com.machinecode.github_project.utils.AppConstant
/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
class RepositoryRVAdapter(private val repositoryCallback: RepositoryCallback) :
    RecyclerView.Adapter<RepositoryRVAdapter.VHolder>() {
    private lateinit var listRepositoryModel: MutableList<RepositoryModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        return VHolder(
            RvRepositoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setRepository(listRepository: MutableList<RepositoryModel>) {
        listRepositoryModel = listRepository
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        try {
            holder.onBind(position)
            holder.itemView.setOnClickListener {
                val accountInformation = listRepositoryModel[position]
                repositoryCallback.repositoryItemClick(accountInformation, position)
            }
        } catch (ex: Exception) {
        }
    }

    override fun getItemCount(): Int {
        return if (listRepositoryModel.size > 0) {
            listRepositoryModel.size
        } else {
            0
        }
    }

    inner class VHolder(val binding: RvRepositoryItemBinding) :
        BaseViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        override fun onBind(position: Int) {
            super.onBind(position)
            val repoModel = listRepositoryModel[position]

            binding.tvFullName.text = "Full name: " + repoModel.getFullName()
            binding.tvDescription.text = "Description: " + repoModel.getDescription()
            binding.tvStarCount.text = "Star count: " + repoModel.getStargazersCount().toString()
            binding.tvLastUpdate.text =
                "Last update " + AppConstant.getSortDataTime(repoModel.getUpdatedAt()!!)
        }
    }
}