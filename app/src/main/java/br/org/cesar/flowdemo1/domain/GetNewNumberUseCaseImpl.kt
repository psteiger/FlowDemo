package br.org.cesar.flowdemo1.domain

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

class GetNewNumberUseCaseImpl : GetNewNumberUseCase {

    private fun getNewNumber() = Random.nextInt()

    override suspend fun generateNewNumbers(
        callback: suspend (newNumber: Int) -> Unit
    ) = withContext(Dispatchers.Default) {

        while (true) {
            Log.d(
                "GetNewNumberUseCaseImpl",
                "Refreshing number ... Thread: ${Thread.currentThread().name}"
            )
            callback(getNewNumber())
            delay(1000)
        }
    }
}