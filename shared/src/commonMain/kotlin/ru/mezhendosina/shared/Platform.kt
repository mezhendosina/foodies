package ru.mezhendosina.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform