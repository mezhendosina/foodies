package ru.mezhendosina.shared.ui.aboutItem

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.ui.entities.ItemEntity

class PreviewAboutItemComponent : AboutItemComponent {
    override val model: Value<AboutItemComponent.Model>
        get() = MutableValue(
            AboutItemComponent.Model(
                ItemEntity(
                    0,
                    "test",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent pellentesque felis vulputate sodales vestibulum. Mauris vel ipsum nec velit hendrerit egestas vel at ex. Phasellus at suscipit quam. Suspendisse pulvinar ante a nulla porttitor, quis maximus augue fermentum. Maecenas sit amet purus posuere, ultrices mi a, cursus justo. Maecenas tempor metus odio, ac condimentum eros luctus ac. Pellentesque scelerisque massa magna, ac sagittis elit placerat et. Nulla vehicula tortor sit amet nulla semper, in porttitor purus maximus. Nam leo est, dignissim eget feugiat id, hendrerit sit amet felis. Nulla ornare volutpat enim at venenatis. Nulla pellentesque finibus varius. Ut rhoncus vitae lorem et tempus. Donec accumsan dignissim commodo. Maecenas pellentesque ac metus quis faucibus. Duis id mi convallis magna venenatis varius.",
                    0,
                    weight = "123",
                    energy = 123.0,
                    proteins = 123.0,
                    fats = 123.0,
                    carbohydrates = 123.0,
                    price = 720.0,
                    count = 1
                )
            )
        )


    override fun onBack() {
        TODO("Not yet implemented")
    }

    override fun onItemCountChanges(count: Int) {
        TODO("Not yet implemented")
    }
}