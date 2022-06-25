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
import com.hmju.livedata.databinding.FSieunBinding
import com.hmju.livedata.dialog.TestDialogFragment
import timber.log.Timber

class SieunFragment : Fragment() {

    private val viewModel: SieunViewModel by viewModels()

    private val activityViewModel: FragmentViewModel by activityViewModels()

    private val testDialogFragment: TestDialogFragment by lazy { TestDialogFragment() }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("onAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Timber.d("onCreateView")
        return DataBindingUtil.inflate<FSieunBinding>(
            inflater,
            R.layout.f_sieun,
            container,
            false
        ).run {
            setVariable(BR.vm, viewModel)
            setVariable(BR.fm, this@SieunFragment)
            lifecycleOwner = this@SieunFragment
            return@run this.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("onViewCreated")
        with(viewModel) {
            startQtzzFragmentEvent.observe(viewLifecycleOwner) {
                Timber.d("QTZZ $it")
                findNavController().navigate(R.id.qtzzFragment)
            }
        }
        activityViewModel.onAddFragmentName(javaClass.simpleName.substringAfterLast("."))
    }

    fun onMoveQtzzFragment() {
        findNavController().navigate(R.id.qtzzFragment)
    }

    fun onShowTestDialogFragment(isNewType: Boolean) {
        if (isNewType) {
            TestDialogFragment().simpleShow(childFragmentManager)
        } else {
            testDialogFragment.simpleShow(childFragmentManager)
        }
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
