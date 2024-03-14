package com.example.lab2

import EventItem
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val eventId = intent.getIntExtra("event_id", -1)
        val eventName = intent.getStringExtra("event_name")
        val eventIsOnline = intent.getBooleanExtra("event_is_online", false)
        val eventQuantityPersons = intent.getIntExtra("event_quantity_persons", 0)

        val eventIdTextView: TextView = findViewById(R.id.event_id)
        val eventNameTextView: TextView = findViewById(R.id.event_name)
        val eventIsOnlineTextView: TextView = findViewById(R.id.event_is_online)
        val eventQuantityPersonsTextView: TextView = findViewById(R.id.event_quantity_persons)

        eventIdTextView.text = "Event ID: $eventId"
        eventNameTextView.text = "Event mame: $eventName"
        eventIsOnlineTextView.text = "Event is online: $eventIsOnline"
        eventQuantityPersonsTextView.text = "Event quantity persons: $eventQuantityPersons"

        val viewContactsButton: Button = findViewById(R.id.view_contacts_button)

        viewContactsButton.setOnClickListener {
            // Создать неявный интент для просмотра контактов
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(ContactsContract.Contacts.CONTENT_URI)

            // Запустить активность для просмотра контактов
            startActivity(intent)
        }

    }

    companion object {

        private const val EXTRA_EVENT_ID = ""
        
        fun eventIntent(context: Context, item: EventItem): Intent  = Intent(
            context, DetailsActivity::class.java
        ).apply {
            putExtra("event_id", item.id)
        }

    }
}
