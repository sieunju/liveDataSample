package com.hmju.livedata.testfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hmju.livedata.BR
import com.hmju.livedata.R
import com.hmju.livedata.databinding.FQtzzBinding
import timber.log.Timber

class QtzzFragment : Fragment() {

    private val viewModel: QtzzViewModel by viewModels()

    private val activityViewModel: FragmentViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("onAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Timber.d("onCreateView")
        return DataBindingUtil.inflate<FQtzzBinding>(
            inflater,
            R.layout.f_qtzz,
            container,
            false
        ).run {
            setVariable(BR.vm,viewModel)
            setVariable(BR.fm,this@QtzzFragment)
            lifecycleOwner = this@QtzzFragment
            return@run this.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("onViewCreated")

        activityViewModel.onAddFragmentName(javaClass.simpleName.substringAfterLast("."))
    }

    fun onMoveAppleFragment(){
        findNavController().navigate(R.id.appleFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
    }
}