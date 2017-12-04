import kotlinx.html.HTML
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

/*
React is nice but requires some boilerplate for state and props that could be avoided using delegation.

The main feature is smart rendering and HTML within code (DSL).
FreshKt idea:
- Use Kotlin delegation to observe state changes with no boilerplate.
- Use Kotlinx.HTML DSL to model HTML within code (like JSX React).
- Rendering asynchronously? (Coroutines)

 */

fun main(args: Array<String>) {
//    render(document.getElementById("root")) {
//
//    }
}

/*
Component:
  state change -> render myself with new state (render children in my html)
*/

abstract class Component {
    fun <T> state(initalValue: T) : StateProperty<T> = StateProperty(initalValue)

    abstract fun render(): HTML
}

class ExampleComponent : Component() {
    val foo by state(5)
    val bar by state("Something")

    override fun render(): HTML {
        TODO()
    }
}

class State {
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Any?) {}
}

class StateProperty<T>(initialValue: T) : ObservableProperty<T>(initialValue) {
    override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean {
        // Don't update if there's no change
        if (oldValue == newValue) return false

        // Do updating / rendering
        return true
    }
}