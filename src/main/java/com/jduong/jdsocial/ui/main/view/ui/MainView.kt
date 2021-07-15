package com.jduong.jdsocial.ui.main.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.jduong.jdsocial.R
import com.jduong.jdsocial.data.repository.UserSelectionRepository
import com.jduong.jdsocial.databinding.ActivityMainViewBinding
import com.jduong.jdsocial.databinding.FragmentHubFragViewBinding
import com.jduong.jdsocial.databinding.PostAdapterBinding
import com.jduong.jdsocial.ui.main.viewmodel.SelectionFragViewModel
import com.jduong.jdsocial.ui.main.viewmodel.SelectionViewModelFactory

class MainView : AppCompatActivity() {

    private lateinit var navController : NavController
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var bottomNavView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainViewBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val navHostFragment : NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView ) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController,appBarConfiguration)
        setupBottomNavMenu(navController)

        val selectionFragViewModel : SelectionFragViewModel by viewModels {
            SelectionViewModelFactory(UserSelectionRepository.getInstance(this))
        }

        selectionFragViewModel.checkPostSelection().observe(this){
            selection->setupMenu(selection)
        }



    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    private fun setupBottomNavMenu(navIn : NavController){
        bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNavView.setupWithNavController(navIn)
        NavigationUI.setupWithNavController(bottomNavView,navIn)
    }

    private fun setupMenu(selection : UserSelectionRepository.Selection){

       bottomNavView.isVisible = when(selection){
           UserSelectionRepository.Selection.POST_VIEW_ALBUM_VIEW->true
           else->false
       }
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragmentContainerView).navigateUp(appBarConfiguration)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_view,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return item.onNavDestinationSelected(findNavController(R.id.fragmentContainerView)) || super.onOptionsItemSelected(item)
    }


}