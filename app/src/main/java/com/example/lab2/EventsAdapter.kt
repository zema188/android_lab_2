import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R

/**
 * Адаптер для RecyclerView.
 * Конструктор принимает список контактов.
 * Наследуемся от RecyclerView.Adapter и переопределяем
 * необходимые методы.
 */
class EventsAdapter(
    private val events: List<EventItem>,
    private val onItemClicked: (item: EventItem) -> Unit,
): RecyclerView.Adapter<EventViewHolder>() {

    private fun onViewHolderClicked(position: Int) {
        onItemClicked(events[position])
    }

    /**
     * Метод по созданию ViewHolder
     */
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): EventViewHolder {
        // создание View из макета для ViewHolder
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.event_item, parent, false)
        return EventViewHolder(view, this::onViewHolderClicked)
    }
    /**
     * Кол-во элементов в адаптере (списке)
     */
    override fun getItemCount(): Int {
        return events.size
    }
    /**
     * Добавление данных на соответсвующий ViewHolder.
     */
    override fun onBindViewHolder(
        holder: EventViewHolder, position: Int
    ) {
        holder.bind(events[position])
    }
}
/**
 * ViewHolder элемента списка.
 * Наследуемся от RecyclerView.ViewHolder
 */
class EventViewHolder(
    itemView: View,
    private val onItemClicked: (position: Int) -> Unit
): RecyclerView.ViewHolder(itemView) {
    private val nameView: TextView = itemView.findViewById(R.id.event_name)
    private val statusView: TextView = itemView.findViewById(R.id.event_status)
    private val quantityView: TextView = itemView.findViewById(R.id.event_persons_quantity)
    /**
     * Метод для связывания данных с ViewHolder
     */

    init {
        itemView.setOnClickListener { onItemClicked(adapterPosition) }
    }

    fun bind(item: EventItem) {
        nameView.text = item.name
        statusView.text = "Status: ${if (item.isOnline) "online" else "offline"}"
        quantityView.text = "${item.quantityPersons} persons"
    }
}


