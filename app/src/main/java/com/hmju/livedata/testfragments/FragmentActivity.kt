package com.hmju.livedata.testfragments

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.hmju.livedata.BR
import com.hmju.livedata.R
import com.hmju.livedata.databinding.AFragmentBinding

class FragmentActivity : AppCompatActivity() {

    private val viewModel: FragmentViewModel by viewModels()

    private lateinit var binding: AFragmentBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<AFragmentBinding>(
            this,
            R.layout.a_fragment
        ).apply {
            lifecycleOwner = this@FragmentActivity
            setVariable(BR.vm, viewModel)
        }
        navController = (supportFragmentManager.findFragmentById(R.id.fcv) as NavHostFragment).navController

    }
}