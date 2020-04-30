package br.org.cesar.flowdemo1.ui

import androidx.lifecycle.*
import br.org.cesar.flowdemo1.data.CounterRepositoryImpl
import br.org.cesar.flowdemo1.domain.CounterRepository

class MainActivityViewModel : ViewModel() {

    private val counterRepository: CounterRepository = CounterRepositoryImpl()

    val counter: LiveData<Int>
        get() = counterRepository.counter.asLiveData()

}