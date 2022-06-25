package com.hmju.livedata.testrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.doOnAttach
import androidx.core.view.doOnDetach
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.hmju.livedata.BR
import com.hmju.livedata.R
import com.hmju.livedata.databinding.VhTestBinding
import timber.log.Timber

/**
 * Description :
 *
 * Created by juhongmin on 2022/06/25
 */
class TestRecyclerViewAdapter(
    private val viewModel: TestRecyclerViewModel
) : RecyclerView.Adapter<TestRecyclerViewAdapter.ViewHolder>() {

    private val dataList = mutableListOf<TestModel>()

    fun setDataList(list: List<TestModel>) {
        dataList.clear()
        dataList.addAll(list)
        notifyItemRangeInserted(0,itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent, viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        if (dataList.size > pos) {
            holder.onBindView(dataList[pos])
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(
        parent: ViewGroup,
        viewModel: TestRecyclerViewModel
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(
                R.layout.vh_test,
                parent,
                false
            )
    ) {

        val binding: VhTestBinding by lazy { DataBindingUtil.bind(itemView)!! }

        init {
            binding.setVariable(BR.vm, viewModel)
            itemView.doOnAttach {
                binding.lifecycleOwner = ViewTreeLifecycleOwner.get(it)
            }

            itemView.doOnDetach {
                binding.lifecycleOwner = null
            }
        }

        fun onBindView(model: TestModel) {
            binding.setVariable(BR.model, model)
        }
    }
}
