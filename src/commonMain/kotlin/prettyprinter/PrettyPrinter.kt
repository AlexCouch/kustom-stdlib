expect object PrettyColors{
    val RESET: String
    val RED: String
    val BLUE: String
    val GREEN: String
    val YELLOW: String
    val WHITE: String
    val BLACK: String
    val UNDERLINE: String
    val BOLD: String
    val ITALIC: String
}

class PrettyPrinter{
    private var indentationLevel = 0
    private val sb = StringBuilder()

    fun append(string: String){
        if(indentationLevel > 0){
            if(string.contains("\n")) {
                val lines = string.split(Regex("(?<=\n)"))
                for(line in lines.withIndex()){
                    if(line.value.isNotBlank()) {
                        (1..this.indentationLevel).forEach {
                            this.sb.append("\t")
                        }
                    }
                    this.sb.append(line.value)
                }
            }else{
                (1..this.indentationLevel).forEach {
                    this.sb.append("\t")
                }
                sb.append(string)
            }
        }else{
            this.sb.append(string)
        }
    }

    fun red(block: PrettyPrinter.()->Unit){
        this.append(PrettyColors.RED)
        this.block()
        this.append(PrettyColors.RESET)
    }

    fun green(block: PrettyPrinter.()->Unit){
        this.append(PrettyColors.GREEN)
        this.block()
        this.append(PrettyColors.RESET)
    }

    fun blue(block: PrettyPrinter.()->Unit){
        this.append(PrettyColors.BLUE)
        this.block()
        this.append(PrettyColors.RESET)
    }

    fun yellow(block: PrettyPrinter.()->Unit){
        this.append(PrettyColors.YELLOW)
        this.block()
        this.append(PrettyColors.RESET)
    }

    fun white(block: PrettyPrinter.()->Unit){
        this.append(PrettyColors.WHITE)
        this.block()
        this.append(PrettyColors.RESET)
    }

    fun black(block: PrettyPrinter.()->Unit){
        this.append(PrettyColors.BLACK)
        this.block()
        this.append(PrettyColors.RESET)
    }

    fun bold(block: PrettyPrinter.()->Unit){
        this.append(PrettyColors.BOLD)
        this.block()
        this.append(PrettyColors.RESET)
    }

    fun italics(block: PrettyPrinter.()->Unit){
        this.append(PrettyColors.ITALIC)
        this.block()
        this.append(PrettyColors.RESET)
    }

    fun underline(block: PrettyPrinter.()->Unit){
        this.append(PrettyColors.UNDERLINE)
        this.block()
        this.append(PrettyColors.RESET)
    }

    fun appendWithNewLine(string: String){
        this.append("$string\n")
    }

    fun indent(block: PrettyPrinter.() -> Unit){
        this.indentationLevel++
        this.block()
        this.indentationLevel--
    }

    override fun toString(): String = this.sb.toString()

}

fun buildPrettyString(block: PrettyPrinter.()->Unit): String{
    val prettyPrinter = PrettyPrinter()
    prettyPrinter.block()
    return prettyPrinter.toString()
}
