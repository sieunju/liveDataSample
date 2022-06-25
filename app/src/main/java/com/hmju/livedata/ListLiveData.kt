package com.hmju.livedata

import androidx.lifecycle.MutableLiveData

/**
 * Description : List LiveData
 *
 * Created by juhongmin on 2022/06/24
 */
class ListLiveData<T> : MutableLiveData<MutableList<T>>() {
    private val temp: MutableList<T> by lazy { mutableListOf() }

    init {
        value = temp
    }

    override fun getValue() = super.getValue()!!
    val size: Int get() = value.size
    operator fun get(idx: Int) =
        if (size > idx) value[idx] else throw ArrayIndexOutOfBoundsException("Index $idx Size $size")

    fun data(): List<T> {
        return temp
    }

    fun add(item: T) {
        temp.add(item)
        value = temp
    }

    fun addAll(list: List<T>) {
        temp.addAll(list)
        value = temp
    }

    fun clear() {
        temp.clear()
        value = temp
    }
}