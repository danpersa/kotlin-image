package com.danix.image

class Rotation : Transformation<RotateParams> {

    override fun transform(params: RotateParams, image: Image): Image {
        println("The image was rotated with the params $params")
        return DefaultImage(image.width, image.height)
    }

    override fun canHandle(params: TransformationParams): Boolean {
        return params is RotateParams
    }
}

data class RotateParams(val angle: Int) : TransformationParams
