package errormanager

import buildPrettyString
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

data class ErrorEntry(val moduleName: String, val message: String)
abstract class ErrorManager<T>{
    protected val errorStream = Channel<ErrorEntry>()

    abstract val module: T

    var hasError = false
        private set

    @ExperimentalCoroutinesApi
    fun start(){
        GlobalScope.launch {
            while(!errorStream.isClosedForSend){
                val errorEntry = errorStream.receive()
                hasError = true
                val (moduleName, message) = errorEntry
                val errorMessage = buildPrettyString {
                    this.appendWithNewLine("An error occurred in $moduleName:")
                    this.indent {
                        this.appendWithNewLine(message)
                    }
                }
                println(errorMessage)
            }
        }

    }

    abstract suspend fun createError(moduleName: String, message: String)

    fun stop(){
        this.errorStream.close()
    }
}