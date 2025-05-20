package org.hogwarts.harrypotter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
