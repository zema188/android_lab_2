import kotlin.random.Random

data class EventItem(
    val id: Int,
    val name: String,
    val isOnline: Boolean,
    val quantityPersons: Int
)

fun events(): List<EventItem> = List(20) { index ->
    val eventId = index + 1
    val eventName = "Event $eventId"
    val isOnline = index > 10
    val quantityPersons = Random.nextInt(1, 101)
    EventItem(eventId, eventName, isOnline, quantityPersons)
}
