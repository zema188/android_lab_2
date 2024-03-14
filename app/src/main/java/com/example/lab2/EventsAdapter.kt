import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R

class EventsAdapter(
    private val events: List<EventItem>,
    private val onItemClicked: (item: EventItem) -> Unit
) : RecyclerView.Adapter<EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
        holder.itemView.setOnClickListener {
            onItemClicked(events[position])
        }
    }

    override fun getItemCount() = events.size
}

class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameView: TextView = itemView.findViewById(R.id.event_name)
    private val statusView: TextView = itemView.findViewById(R.id.event_status)
    private val quantityView: TextView = itemView.findViewById(R.id.event_persons_quantity)

    fun bind(item: EventItem) {
        nameView.text = item.name
        statusView.text = "Status: ${if (item.isOnline) "online" else "offline"}"
        quantityView.text = "${item.quantityPersons} persons"
    }
}