package com.acrylic.ui

import com.acrylic.threads.RunningLoop

abstract class RunningAbstractCanvasUI : AbstractCanvasUI, RunningLoop {

    constructor(title: String?) : super(title) {
        startRunning()
    }

    constructor(title: String?, width: Int, height: Int) : super(title, width, height) {
        startRunning()
    }

    override fun run() {
        render()
    }

}