package com.acrylic.ui

import java.awt.Canvas
import java.awt.Graphics
import java.util.function.Consumer
import javax.swing.JFrame

abstract class AbstractCanvasUI(title: String?) : Canvas(), BaseUI {
    override val jFrame: JFrame

    constructor(title: String?, width: Int, height: Int) : this(title) {
        setDimension(width, height)
    }

    private fun setupCanvas() {
        size = jFrame.size
        preferredSize = jFrame.size
        maximumSize = jFrame.size
        minimumSize = jFrame.size
    }

    fun modifyGraphics(action: Consumer<Graphics?>) {
        val bufferStrategy = bufferStrategy
        if (bufferStrategy == null) {
            createBufferStrategy(2)
            return
        }
        val graphics = bufferStrategy.drawGraphics
        action.accept(graphics)
        graphics.dispose()
        bufferStrategy.show()
    }

    abstract override fun render()

    init {
        jFrame = JFrame(title)
        jFrame.add(this)
        setupJFrame()
        setRelativeSize()
        setupCanvas()
        createBufferStrategy(2)
    }
}