package com.example.lab2

import EventItem
import EventsAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import events

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list: RecyclerView = findViewById(R.id.list)
        val adapter = EventsAdapter(events(), this::onEventItemClicked)
        list.adapter = adapter
    }
    private fun onEventItemClicked(item: EventItem) {
        val detailsIntent = Intent(this, DetailsActivity::class.java)
        detailsIntent.putExtra("event_id", item.id)
        detailsIntent.putExtra("event_name", item.name)
        detailsIntent.putExtra("event_is_online", item.isOnline)
        detailsIntent.putExtra("event_quantity_persons", item.quantityPersons)
        startActivity(detailsIntent)
    }
}
