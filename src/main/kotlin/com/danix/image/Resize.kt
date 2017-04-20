package com.danix.image

data class ResizeParams(val width: Int,
                        val height: Int) : TransformationParams


class Resize : Transformation<ResizeParams> {
    override fun transform(params: ResizeParams, image: Image): Image {
        println("The image was resized with the params $params")
        return DefaultImage(params.width, params.height)
    }

    override fun canHandle(params: TransformationParams): Boolean
            = params is ResizeParams
}
