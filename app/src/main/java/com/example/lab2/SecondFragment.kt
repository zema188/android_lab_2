import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lab2.R

class SecondFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val eventItem = arguments?.getParcelable<EventItem>(EVENT_ITEM_KEY)
        // Отображаем информацию о событии
        eventItem?.let {
            view.findViewById<TextView>(R.id.event_name).text = it.name
            view.findViewById<TextView>(R.id.event_status).text = "Status: ${if (it.isOnline) "online" else "offline"}"
            view.findViewById<TextView>(R.id.event_persons_quantity).text = "${it.quantityPersons} persons"
        }
    }

    companion object {
        private const val EVENT_ITEM_KEY = "event_item"

        fun newInstance(eventItem: EventItem): SecondFragment {
            val fragment = SecondFragment()
            val args = Bundle().apply {
                putParcelable(EVENT_ITEM_KEY, eventItem)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
