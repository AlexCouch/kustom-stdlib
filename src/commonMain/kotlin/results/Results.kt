package results

import buildPrettyString

interface Result<T>

class OKResult<T>: Result<T>
class WrappedResult<T>(val t: T): Result<T>
class ErrorResult<T>(val message: String, val cause: ErrorResult<*>? = null): Result<T>{
    override fun toString(): String {
        return buildPrettyString {
            this.appendWithNewLine("ErrorResult{")
            this.indent {
                this.appendWithNewLine("Error Message: $message")
                this.appendWithNewLine("Cause: $cause")
            }
            this.append("}")
        }
    }
}