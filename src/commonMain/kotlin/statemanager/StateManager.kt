package statemanager

import results.Result

data class StateStackEntry(val stateName: String, val resultStr: String)
data class StateManagerResult<out T>(val data: T, override val message: String): Result(message)
interface BasicState<in T>: BiResultState<T, Boolean, BasicState<T>>
interface BiResultState<in T, out R, out V>{
    suspend fun transitionTo(moduleInstance: T): StateManagerResult<R>
    suspend fun transitionFrom(moduleInstance: T): StateManagerResult<V>
}

interface StateManager<T>{
    val stateStack: ArrayList<StateStackEntry>
    var currentState: T
    val finalStates: List<T>
}

expect abstract class BasicStateManager<T>: StateManager<BasicState<T>>{
    override val stateStack: ArrayList<StateStackEntry>
    internal abstract val module: T

    suspend fun start(): Result
}