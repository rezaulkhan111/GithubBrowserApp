package com.machinecode.github_project.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.machinecode.github_project.R
import com.machinecode.github_project.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.fragment_container_nav_host)
//        navController.navigate(R.id.fghomeFragment)
    }
}