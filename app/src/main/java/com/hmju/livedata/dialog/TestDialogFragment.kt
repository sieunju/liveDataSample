package com.hmju.livedata.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hmju.livedata.BR
import com.hmju.livedata.R
import com.hmju.livedata.databinding.DTestBinding
import timber.log.Timber

/**
 * Description :
 *
 * Created by juhongmin on 2022/06/25
 */
class TestDialogFragment : BottomSheetDialogFragment() {

    private val viewModel: TestDialogFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Timber.d("onCreateView")
        return DataBindingUtil.inflate<DTestBinding>(inflater, R.layout.d_test, container, false)
            .run {
                setVariable(BR.vm, viewModel)
                lifecycleOwner = this@TestDialogFragment
                this.root
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("onViewCreated ${viewModel.hashCode()}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
    }

    fun simpleShow(fm: FragmentManager){
        show(fm, javaClass.simpleName)
    }
}
