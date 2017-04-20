package com.danix.image

data class CropParams(val x: Int,
                      val y: Int,
                      val width: Int,
                      val height: Int) : TransformationParams

class Crop : Transformation<CropParams> {

    override fun transform(params: CropParams, image: Image): Image {
        println("The image was cropped with the params $params")
        return DefaultImage(params.width, params.height)
    }

    override fun canHandle(params: TransformationParams): Boolean
            = params is CropParams
}