package com.machinecode.github_project.ui.common

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.machinecode.github_project.viewModel.GithubViewModel
/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
open class BaseFragment : Fragment() {
    val viewModelGitHub: GithubViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}