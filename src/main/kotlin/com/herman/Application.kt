package com.herman

import com.herman.auth.configureSecurity
import com.herman.plugins.DatabaseFactory
import com.herman.plugins.configureLogging
import com.herman.plugins.configurePaging
import com.herman.plugins.configureRouting
import com.herman.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureRouting()
    configureSerialization()
    configurePaging()
    configureLogging()
    configureSecurity()
    DatabaseFactory.init()

}
