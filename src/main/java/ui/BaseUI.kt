package com.acrylic.ui

import java.awt.Dimension
import java.awt.Image
import java.awt.Toolkit
import javax.swing.JFrame
import javax.swing.WindowConstants

interface BaseUI {
    val jFrame: JFrame
    fun render()
    fun setupJFrame() {
        val jFrame = jFrame
        jFrame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        jFrame.isResizable = true
        jFrame.isVisible = true
        jFrame.pack()
    }

    fun setIcon(image: Image?): BaseUI? {
        jFrame.iconImage = image
        return this
    }

    fun setDimension(dimension: Dimension?): BaseUI? {
        val jFrame = jFrame
        jFrame.size = dimension
        jFrame.preferredSize = dimension
        jFrame.minimumSize = dimension
        jFrame.maximumSize = dimension
        return this
    }

    fun setDimension(width: Int, height: Int): BaseUI? {
        return setDimension(Dimension(width, height))
    }

    fun setRelativeSize(): BaseUI? {
        return setRelativeSize(1f)
    }

    fun setRelativeSize(scale: Float): BaseUI? {
        val dimension = Toolkit.getDefaultToolkit().screenSize
        setDimension((dimension.getWidth() * scale).toInt(), (dimension.getHeight() * scale).toInt())
        return this
    }
}