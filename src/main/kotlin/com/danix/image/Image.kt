package com.danix.image

interface Image {
    val width: Int
    val height: Int
}

object DummyImage : Image {
    override val width = 800
    override val height = 600
}

class DefaultImage(override val width: Int, override val height: Int) : Image
