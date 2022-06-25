package com.hmju.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

/**
 * Description :
 *
 * Created by juhongmin on 2022/06/24
 */
class MainViewModel : ViewModel() {

    private val _clickCountEvent : MutableLiveData<String> by lazy { MutableLiveData() }
    val clickCountEvent : LiveData<String> get() = _clickCountEvent

    val startFragmentTestEvent : MutableLiveData<Unit> by lazy { MutableLiveData() }
    val startRecyclerViewTestEvent : MutableLiveData<Unit> by lazy { MutableLiveData() }


    fun onClickCount(){
        _clickCountEvent.value = "CNT_${System.currentTimeMillis()}"
    }

    fun onMoveTestFragment(){
        startFragmentTestEvent.value = null
    }

    fun onMoveTestRecyclerView(){
        startRecyclerViewTestEvent.value = null
    }
}