pluginManagement{
    plugins{
        kotlin("jvm").version("1.7.22")
    }
}

rootProject.name = "pkotlin-gradle"
include("basics")
include("coroutines-basics")
include("gradle1")
include("http4k")
include("kotest")
include("kotlin-java")
include("statistics")
include("websocket")
