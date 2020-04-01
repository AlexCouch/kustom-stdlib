actual object PrettyColors {
    actual val RED: String
        get() = "\u001B[31m"
    actual val BLUE: String
        get() = "\u001B[34m"
    actual val GREEN: String
        get() = "\u001B[32m"
    actual val YELLOW: String
        get() = "\u001B[33m"
    actual val WHITE: String
        get() = "\u001B[30m"
    actual val BLACK: String
        get() = "\u001B[37m"
    actual val UNDERLINE: String
        get() = "\u001B[04m"
    actual val BOLD: String
        get() = "\u001B[01m"
    actual val ITALIC: String
        get() = "\u001B[03m"
    actual val RESET: String
        get() = "\u001B[0m"

}