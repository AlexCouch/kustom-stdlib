import kotlin.test.Test

@Test
fun test(){
    println(buildPrettyString {
        this.red {
            this.appendWithNewLine("Red text")
        }
        this.blue {
            this.appendWithNewLine("Blue text")
        }
        this.green {
            this.appendWithNewLine("Green text")
        }
        this.yellow {
            this.appendWithNewLine("Yellow text")
        }
        this.white {
            this.appendWithNewLine("White text")
        }
        this.black {
            this.appendWithNewLine("Black text")
        }
        this.bold {
            this.appendWithNewLine("Bold text")
        }
        this.italics {
            this.appendWithNewLine("Italic text")
        }
        this.underline {
            this.appendWithNewLine("Underlined text")
        }
    })
}