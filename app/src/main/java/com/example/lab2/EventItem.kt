import kotlin.random.Random

data class EventItem(
    val name: String,
    val isOnline: Boolean,
    val quantityPersons: Int
)

fun events(): List<EventItem> = List(20) { index ->
    val eventName = "Event $index"
    val isOnline = index > 10
    val quantityPersons = Random.nextInt(1, 101)
    EventItem(eventName, isOnline, quantityPersons)
}
