package br.org.cesar.flowdemo1.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.Flow

interface CounterRepository {

//    val counter: LiveData<Int>

    val counter: Flow<Int>

}