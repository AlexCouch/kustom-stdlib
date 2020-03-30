package statemanager

import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import results.OKResult
import results.Result

actual abstract class BasicStateManager<T> : StateManager<BasicState<T>> {
    actual override val stateStack: ArrayList<StateStackEntry> = arrayListOf()
    internal actual abstract val module: T
    actual suspend fun start(): Result<T> {
        val stateStackFlow = flow{
//            println("Starting state transition")
            while(!finalStates.contains(currentState)) {
                val messageBuilder = StringBuilder()
                //State predication; this is checking what state to transition to next
                val predicateResult = this@BasicStateManager.currentState.transitionFrom(this@BasicStateManager.module)
                messageBuilder.append("Predication result:\n")
                messageBuilder.append("\t${predicateResult.message}\n")
                this@BasicStateManager.currentState = predicateResult.data
                messageBuilder.append("Propogation result:\n")
                //State propagation; this is the invoking of the state and its effects on the module
                val propogateResult = currentState.transitionTo(module)
                messageBuilder.append(propogateResult.message)
                if (!propogateResult.data) {
                    messageBuilder.append("\tFailed to transition to ${currentState::class}\n")
                    messageBuilder.append("\t\tDetails:\n")
                    messageBuilder.append(propogateResult.message)
                    break
                }
                emit(StateStackEntry(currentState.toString(), messageBuilder.toString()))
            }
        }
        stateStackFlow.buffer().collect{
//            println(it.resultStr)
            this.stateStack.add(it)
        }
        return OKResult()
    }

}