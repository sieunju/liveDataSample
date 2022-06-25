package com.hmju.livedata

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hmju.livedata.databinding.AMainBinding
import com.hmju.livedata.testfragments.FragmentActivity
import com.hmju.livedata.testrecyclerview.TestRecyclerViewActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: AMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<AMainBinding>(
            this,
            R.layout.a_main
        ).apply {
            lifecycleOwner = this@MainActivity
            setVariable(BR.vm, viewModel)
        }

        with(viewModel) {
            startFragmentTestEvent.observe(this@MainActivity) {
                Intent(this@MainActivity, FragmentActivity::class.java).apply {
                    startActivity(this)
                }
            }

            startRecyclerViewTestEvent.observe(this@MainActivity) {
                Intent(this@MainActivity,TestRecyclerViewActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }

        initTimber()
    }

    private fun initTimber(){
        Timber.plant(object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement): String? {
                return "SIEUN_${element.fileName}"
            }
        })
    }
}