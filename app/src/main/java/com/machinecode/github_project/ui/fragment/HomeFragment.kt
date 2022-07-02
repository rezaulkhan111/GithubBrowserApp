package com.machinecode.github_project.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.machinecode.github_project.R
import com.machinecode.github_project.data.model.RepositoryModel
import com.machinecode.github_project.data.model.appModel.SortModel
import com.machinecode.github_project.data.remote.Status
import com.machinecode.github_project.databinding.FragmentHomeBinding
import com.machinecode.github_project.ui.adapter.RepositoryRVAdapter
import com.machinecode.github_project.ui.callback.RepositoryCallback
import com.machinecode.github_project.ui.common.BaseFragment
import com.machinecode.github_project.utils.AppConstant
import com.machinecode.github_project.utils.AppConstantUtils
import dagger.hilt.android.AndroidEntryPoint
/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
@AndroidEntryPoint
open class HomeFragment : BaseFragment(), RepositoryCallback {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    private lateinit var hmRepoSearch: HashMap<String, Any>
    private lateinit var repoAdapter: RepositoryRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)

        initializedUI()
        repoAdapter = RepositoryRVAdapter(this)
        hmRepoSearch = HashMap()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializedUIData()

        binding.btnSearch.setOnClickListener {
            hmRepoSearch["q"] = binding.tietSearch.text.toString()
            initializedUIData()
        }
    }

    private fun initializedUI() {
        var radioButton: RadioButton
        val sortItemlist = mutableListOf<SortModel>()
        sortItemlist.add(SortModel().apply {
            sortItemFullName = "Most stars"
            sortItemCode = "stars"
            sortItemOtherCode = "desc"
        })
        sortItemlist.add(SortModel().apply {
            sortItemFullName = "Recently updated"
            sortItemCode = "updated"
            sortItemOtherCode = "desc"
        })
        sortItemlist.add(SortModel().apply {
            sortItemFullName = "Least recently updated"
            sortItemCode = "updated"
            sortItemOtherCode = "asc"
        })

        for ((idCount, sortItem) in (0 until sortItemlist.size).withIndex()) {
            radioButton = AppConstant.createRadioButton(
                requireContext(),
                sortItemlist[sortItem].sortItemFullName,
                idCount,
                false
            )
            binding.radioGroup.addView(
                radioButton
            )
            binding.radioGroup.setOnCheckedChangeListener { _, checkId ->
                hmRepoSearch[AppConstantUtils.mQuery] = binding.tietSearch.text.toString()
                hmRepoSearch[AppConstantUtils.mOrder] = sortItemlist[checkId].sortItemOtherCode
                hmRepoSearch[AppConstantUtils.mSort] = sortItemlist[checkId].sortItemCode
                hmRepoSearch["type"] = "Repositories"
            }
        }
    }

    private fun initializedUIData() {
        hmRepoSearch[AppConstantUtils.mPer_page] = "50"
        viewModelGitHub.fetchSearchRepositories(hmRepoSearch).observe(viewLifecycleOwner) {
            if (it != null) {
                repoAdapter.setRepository(it.data.getItems()!!)
                binding.rvRepository.layoutManager =
                    LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                binding.rvRepository.adapter = repoAdapter
            }
        }
    }

    override fun repositoryItemClick(repositoryModel: RepositoryModel, position: Int) {
        val bundle = Bundle()
        bundle.putString(
            AppConstantUtils.bundleParameterModel,
            AppConstant.getJsonStringToObject(repositoryModel)
        )
        navController.navigate(
            R.id.action_fghomeFragment_to_fgRepositoryDetailsFragment,
            bundle
        )
    }
}