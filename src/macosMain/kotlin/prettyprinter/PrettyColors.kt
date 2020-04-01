actual object PrettyColors {
    actual val RED: String
        get() = "\\x1b1B[31m"
    actual val BLUE: String
        get() = "\\x1b1B[34m"
    actual val GREEN: String
        get() = "\\x1b1B[32m"
    actual val YELLOW: String
        get() = "\\x1b1B[33m"
    actual val WHITE: String
        get() = "\\x1b1B[37m"
    actual val BLACK: String
        get() = "\\x1b1B[30m"
    actual val UNDERLINE: String
        get() = "\\x1b1B[04m"
    actual val BOLD: String
        get() = "\\x1b1B[01m"
    actual val ITALIC: String
        get() = "\\x1b1B[03m"
    actual val RESET: String
        get() = "\\x1b1B[0m"
}