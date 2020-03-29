package results

import buildPrettyString

abstract class Result(open val message: String)

class OKResult(override val message: String = ""): Result(""){
    override fun toString(): String {
        return buildPrettyString {
            this.appendWithNewLine("ErrorResult{")
            this.indent {
                this.appendWithNewLine("Message: $message")
            }
            this.appendWithNewLine("}")
        }
    }
}
class WrappedResult<T>(override val message: String = "", val t: T): Result(message){
    override fun toString(): String {
        return buildPrettyString {
            this.appendWithNewLine("ErrorResult{")
            this.indent {
                this.appendWithNewLine("Message: $message")
                this.append("Wrapped Object: $t")
            }
            this.appendWithNewLine("}")
        }
    }
}
class ErrorResult(override val message: String, val cause: ErrorResult?): Result(message){
    override fun toString(): String {
        return buildPrettyString {
            this.appendWithNewLine("ErrorResult{")
            this.indent {
                this.appendWithNewLine("Error Message: $message")
                this.append("Cause: $cause")
            }
            this.appendWithNewLine("}")
        }
    }
}