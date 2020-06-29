# kustom-stdlib
Some standard stuff I will be reusing for a lot of my projects

# Use
### Pretty String Builder
Pretty String Builder lets you build pretty strings with ease. Allows you to append strings with indentation levels, colors, and styles.

Basic:
```kotlin
class A{
    override fun toString() =
        buildPrettyString{
            append("This is a basic append")
            appendWithNewLine(", this is a basic append with new line")
            append("This is on the next line")
        }
}

val a = A()
println(a)
```
Output:
```
This is a basic append, this is a basic append with new line
This is on the next line
```

Indentation level:
```kotlin
class A{
    override fun toString() =
        buildPrettyString{
            append("This is a basic append")
            appendWithNewLine(", this is a basic append with new line")
            appendWithNewLine("This is on the next line")
            indent{
                appendWithNewLine("This has one indentation level")
                indent{
                    appendWithNewLine("This has two indentation levels")
                    indent{
                        appendWithNewLine("etc")
                    }
                    appendWithNewLine("Two indentations")
                }
                appendWithNewLine("One indentation")
            }
            append("No indentations")
        }
}

val a = A()
println(a)
```

Output:
```
This is a basic append, this is a basic append with new line
This is on the next line
    This has one indentation level
        This has two indentation levels
            etc
        Two indentations
    One indentation
No indentation
```

Colors:
```kotlin
class A{
    override fun toString() =
        buildPrettyString{
            red{
                append("This is a red colored append")
            }
            blue{
                append("This is a blue colored append")
            }
            yellow{
                append("This is a yellow colored append")
            }
            green{
                append("This is a green colored append")
            }
            purple{
                append("This is a purple colored append")
            }
            brightRed{
                append("This is a brightRed colored append")
            }
            append("Etc")
        }
}

val a = A()
println(a)
```

### And More
Async State Machine library, async error manager, result types

# Installation
Multiplatform:
```gradle
repositories {
    mavenCentral()
    maven{
        url "https://dl.bintray.com/alexcouch/kustom-stdlib"
    }
}

sourceSets{
    commonMain{
        implementation "com.couch.kustom-stdlib:kustom-stdlib:$kustom_stdlib_version"
    }
    jvmMain {
        dependencies {
            implementation "com.couch.kustom-stdlib:kustom-stdlib:$kustom_stdlib_version"
        }
    }
    jsMain {
        dependencies {
            implementation "com.couch.kustom-stdlib:kustom-stdlib:$kustom_stdlib_version"
        }
    }
}
```

JVM:
```gradle
repositories {
    mavenCentral()
    maven{
        url "https://dl.bintray.com/alexcouch/kustom-stdlib"
    }
}

dependencies{
    implementation "com.couch.kustom-stdlib:kustom-stdlib:$kustom_stdlib_version"
}
```
