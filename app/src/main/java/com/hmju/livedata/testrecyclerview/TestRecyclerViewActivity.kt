package com.hmju.livedata.testrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.hmju.livedata.BR
import com.hmju.livedata.R
import com.hmju.livedata.databinding.ATestRecyclerViewBinding

class TestRecyclerViewActivity : AppCompatActivity() {

    private val viewModel: TestRecyclerViewModel by viewModels()

    private lateinit var binding: ATestRecyclerViewBinding

    private val adapter : TestRecyclerViewAdapter by lazy { TestRecyclerViewAdapter(viewModel) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ATestRecyclerViewBinding>(
            this,
            R.layout.a_test_recycler_view
        ).apply {
            lifecycleOwner = this@TestRecyclerViewActivity
            setVariable(BR.vm,viewModel)
        }

        binding.rvContents.adapter = adapter

        with(viewModel) {
            dataList.observe(this@TestRecyclerViewActivity) {
                adapter.setDataList(it)
            }

            start()
            ranTitle()
        }
    }
}