package com.danix.image

interface TransformationParams

interface Transformation<out P : TransformationParams> : HasCapability<TransformationParams> {
    fun transform(params: @UnsafeVariance P, image: Image): Image
}

// these should be injected
class TransformationService(private val transformationStrategies:
                            List<Transformation<TransformationParams>>) {

    fun transform(params: TransformationParams, image: Image): Image =
            findStrategy(params).
                    transform(params, image)

    private fun findStrategy(params: TransformationParams): Transformation<*> =
            transformationStrategies.findOr(Identity) { strategy ->
                strategy.canHandle(params)
            }
}

internal object Identity : Transformation<TransformationParams> {

    override fun transform(params: TransformationParams, image: Image): Image {
        println("The image was not modified")
        return DummyImage
    }

    override fun canHandle(params: TransformationParams): Boolean
            = false
}

private inline fun <T> Iterable<T>.findOr(or: T, predicate: (T) -> Boolean): T {
    this
            .filter { predicate(it) }
            .forEach { return it }
    return or
}

