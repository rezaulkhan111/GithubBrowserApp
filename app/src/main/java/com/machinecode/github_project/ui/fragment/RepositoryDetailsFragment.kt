package com.machinecode.github_project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.machinecode.github_project.R
import com.machinecode.github_project.data.model.RepositoryModel
import com.machinecode.github_project.databinding.ActivityMainBinding
import com.machinecode.github_project.databinding.FragmentRepositoryDetailsBinding
import com.machinecode.github_project.ui.common.BaseFragment
import com.machinecode.github_project.utils.AppConstant
/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
class RepositoryDetailsFragment : BaseFragment() {
    private lateinit var binding: FragmentRepositoryDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepositoryDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val argParameterRepository = AppConstant
            .getObjectFromJson(
                HomeFragmentArgs
                    .fromBundle(requireArguments())
                    .parameterModel, RepositoryModel()
            ) as RepositoryModel
        argParameterRepository.apply {
            AppConstant.loadImage(
                getOwner()!!.getAvatarUrl(),
                binding.ivOwnerImage
            )
            binding.tvOwnerName.text = getOwner()!!.getLogin()
            binding.tvRepositoryDescription.text = getDescription()
            binding.tvRepositoryLastUpdateDate.text = AppConstant.getSortDataTime(getUpdatedAt()!!)
        }
    }
}