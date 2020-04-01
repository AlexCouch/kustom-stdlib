actual object PrettyColors {
    actual val RESET: String
        get() = "\\033[0m"
    actual val RED: String
        get() = "\\033[31m"
    actual val BLUE: String
        get() = "\\033[34m"
    actual val GREEN: String
        get() = "\\033[32m"
    actual val YELLOW: String
        get() = "\\033[33m"
    actual val WHITE: String
        get() = "\\033[37m"
    actual val BLACK: String
        get() = "\\033[30m"
    actual val UNDERLINE: String
        get() = "\\033[04m"
    actual val BOLD: String
        get() = "\\033[01m"
    actual val ITALIC: String
        get() = "\\033[03m"
}