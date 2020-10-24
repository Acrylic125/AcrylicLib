package com.acrylic.ui

import java.awt.Color
import java.awt.Graphics

class TestUI : RunningAbstractCanvasUI {
    override var isRunning: Boolean = false

    constructor(title: String?) : super(title) {}
    constructor(title: String?, width: Int, height: Int) : super(title, width, height) {}

    override fun render() {
        modifyGraphics { graphics: Graphics? ->
            graphics!!.color = Color.BLACK
            graphics.fillRect(0, 0, 100, 100)
        }
    }
}