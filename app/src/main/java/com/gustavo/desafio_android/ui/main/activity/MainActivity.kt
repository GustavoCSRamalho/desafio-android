package com.gustavo.desafio_android.ui.main.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*

import com.gustavo.desafio_android.R
import com.gustavo.desafio_android.databinding.MainActivityBinding
import com.gustavo.desafio_android.model.Repository
import com.gustavo.desafio_android.ui.main.activity.interf.ChangePageInterf
import com.gustavo.desafio_android.ui.main.activity.interf.OpenUrlInterf


class MainActivity : AppCompatActivity(), ChangePageInterf<Repository>, OpenUrlInterf {

    private lateinit var navController: NavController

    private lateinit var toolbar: Toolbar

    private lateinit var navHostFragment: NavHostFragment

    private lateinit var dataBindingUtil: MainActivityBinding

    private lateinit var repository:Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVariables()
        configureToolbar()
        setNavigationFragmentListener(dataBindingUtil)
        setup(toolbar)
    }

    private fun configureToolbar() {
        toolbar.title = "Heloo"
        toolbar.setNavigationIcon(R.drawable.ic_drawer)
    }

    private fun initVariables() {
        dataBindingUtil =
            DataBindingUtil.setContentView(this, R.layout.main_activity) as MainActivityBinding
        toolbar = dataBindingUtil.mainActivityToolbar
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_activity_nav_host) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun setNavigationFragmentListener(contentView: MainActivityBinding) {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.repositoryListFragment -> {
                    navController.currentDestination!!.label = "Github JavaPop"
                    contentView.mainActivityToolbar.setNavigationIcon(R.drawable.ic_drawer)
                }
                R.id.pullRequestListFragment -> {
                    navController.currentDestination!!.label = repository.name
                    contentView.mainActivityToolbar.setNavigationIcon(R.drawable.ic_drawer)
                }
                else -> ""
            }
        }
    }

    private fun setup(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.main_activity_nav_host)
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }

    override fun openURL(url: String){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    override fun changePage(fragment: Int, repositoryRef: Repository){
        repository = repositoryRef
        var bundle = bundleOf("repository" to repositoryRef)
        var navHost = supportFragmentManager.findFragmentById(R.id.main_activity_nav_host)!!
        NavHostFragment.findNavController(navHost).navigate(fragment,bundle)
    }

}