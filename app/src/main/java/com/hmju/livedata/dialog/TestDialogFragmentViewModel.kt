package com.hmju.livedata.dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Description :
 *
 * Created by juhongmin on 2022/06/25
 */
class TestDialogFragmentViewModel : ViewModel() {

    private val _title: MutableLiveData<String> by lazy { MutableLiveData() }
    val title: LiveData<String> get() = _title

}
