package com.acrylic.threads

interface RunningLoop {
    fun run()

    var isRunning: Boolean

    fun startRunning() {
        isRunning = true
        while (isRunning) {
            run()
        }
    }
}