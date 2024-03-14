import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R

class EventsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_events, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val eventsAdapter = EventsAdapter(generateEvents()) { eventItem ->
            // Передаем объект EventItem в SecondFragment
            val secondFragment = SecondFragment.newInstance(eventItem)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_host, secondFragment)
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = eventsAdapter
        return view
    }

    // Генерация списка событий
    private fun generateEvents(): List<EventItem> {
        val eventsList = mutableListOf<EventItem>()
        for (index in 0 until 20) {
            val eventId = index + 1
            val eventName = "Event $eventId"
            val isOnline = index > 10
            val quantityPersons = (1..100).random()
            eventsList.add(EventItem(eventId, eventName, isOnline, quantityPersons))
        }
        return eventsList
    }
}
