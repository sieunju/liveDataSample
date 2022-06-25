package com.hmju.livedata.testrecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hmju.livedata.ListLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import kotlin.random.Random

/**
 * Description :
 *
 * Created by juhongmin on 2022/06/25
 */
class TestRecyclerViewModel : ViewModel() {

    private val _dataList: ListLiveData<TestModel> by lazy { ListLiveData() }
    val dataList: ListLiveData<TestModel> get() = _dataList

    private val _rvTitle: MutableLiveData<String> by lazy { MutableLiveData() }
    val rvTitle : LiveData<String> get() = _rvTitle

    fun start() {
        viewModelScope.launch(Dispatchers.Main) {
            val list = dummyList()
            _dataList.addAll(list)
        }
    }

    fun ranTitle(){
        val ranArr = listOf<String>("가","나","다","라","마","바","사")
        viewModelScope.launch(Dispatchers.Main) {
            repeat(100) {
                _rvTitle.value = ranArr[Random.nextInt(ranArr.size)]
                Timber.d("RanTitle ${rvTitle.value}")
                delay(1500)
            }
        }
    }

    private suspend fun dummyList(): List<TestModel> {
        return withContext(Dispatchers.IO) {
            val list = mutableListOf<TestModel>()
            for (idx in 0 until 30) {
                list.add(TestModel(uid = idx, title = "$idx-Hello~"))
            }
            return@withContext list
        }
    }
}