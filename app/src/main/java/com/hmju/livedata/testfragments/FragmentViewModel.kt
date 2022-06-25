package com.hmju.livedata.testfragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel : ViewModel() {
    private val _stackFragmentName: MutableLiveData<String> by lazy { MutableLiveData() }
    val stackFragmentName: LiveData<String> get() = _stackFragmentName

    fun onAddFragmentName(fragmentName: String) {
        val buffer = StringBuilder(stackFragmentName.value ?: "")
        buffer.append(fragmentName)
        buffer.append("-")
        _stackFragmentName.value = buffer.toString()
    }
}
