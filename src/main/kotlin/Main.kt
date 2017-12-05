import kotlinx.html.BODY
import kotlinx.html.HTMLTag
import kotlinx.html.div
import kotlin.browser.document

abstract class Component {
    //    abstract fun BODY.render()
    abstract val render: HTMLTag.() -> Unit
}

class MyComponent : Component() {
    override val render: HTMLTag.() -> Unit =  {

    }
}

fun <T, C : kotlinx.html.TagConsumer<T>> C.fresh(classes: kotlin.String? null, block: kotlinx.html.DIV.() -> kotlin.Unit /* = compiled code */): T { /* compiled code */ }

private fun BODY.add(component: Component) {
    component.render(this)
}

fun render(block: BODY.() -> Unit) {}

fun main(args: Array<String>) {
    render {
        div {
            add(MyComponent())
        }
    }
}

/*
render {
  +"test"
  +MyComponent(arg1, arg2)


}
 */