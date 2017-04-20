import com.danix.image.Crop
import com.danix.image.CropParams
import com.danix.image.DummyImage
import com.danix.image.Resize
import com.danix.image.ResizeParams
import com.danix.image.Rotation
import com.danix.image.RotateParams
import com.danix.image.TransformationService

fun main(ags: Array<String>): Unit {
    val transformationService = TransformationService(listOf(Crop(), Resize(), Rotation()))
    transformationService.transform(ResizeParams(800, 600), DummyImage)
    transformationService.transform(CropParams(800, 600, 100, 200), DummyImage)
    transformationService.transform(RotateParams(30), DummyImage)
}
