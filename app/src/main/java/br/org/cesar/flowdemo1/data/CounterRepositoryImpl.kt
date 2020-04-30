package br.org.cesar.flowdemo1.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.org.cesar.flowdemo1.domain.CounterRepository
import br.org.cesar.flowdemo1.domain.GetNewNumberUseCase
import br.org.cesar.flowdemo1.domain.GetNewNumberUseCaseImpl
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn

class CounterRepositoryImpl : CounterRepository {

    private val getNewNumberUseCase: GetNewNumberUseCase = GetNewNumberUseCaseImpl()
    private val scope = CoroutineScope(Dispatchers.Default)

    /** With LiveData */
//    private val _counter = MutableLiveData(0)
//    override val counter: LiveData<Int>
//        get() = _counter
//
//    init {
//        scope.launch {
//            getNewNumberUseCase.generateNewNumbers {
//                _counter.postValue(it)
//            }
//        }
//    }

    /** With ConflatedBroadcastChannel converted to Flow */
//    private val _counter = ConflatedBroadcastChannel<Int>()
//    override val counter = _counter.asFlow()
//
//    init {
//        scope.launch {
//            getNewNumberUseCase.generateNewNumbers { _counter.send(it) }
//        }
//    }

    /** With CallbackFlow constructor */
    override val counter = callbackFlow {
        getNewNumberUseCase.generateNewNumbers { send(it) }
    }

}