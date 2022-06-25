package com.hmju.livedata.testfragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SieunViewModel : ViewModel() {

    val startQtzzFragmentEvent: MutableLiveData<Unit> by lazy { MutableLiveData() }

    fun onMoveFragment() {
        startQtzzFragmentEvent.value = null
    }
}