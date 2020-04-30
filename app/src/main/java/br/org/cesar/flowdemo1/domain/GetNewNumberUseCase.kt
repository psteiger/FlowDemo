package br.org.cesar.flowdemo1.domain

interface GetNewNumberUseCase {

    suspend fun generateNewNumbers(callback: suspend (newNumber: Int) -> Unit)

}