# kustom-stdlib
Some standard stuff I will be reusing for a lot of my projects

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
