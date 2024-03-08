package com.example.lab2

import EventItem
import EventsAdapter
import android.os.Bundle
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
        Toast.makeText(
            this, "Event: ${item.name} clicked!", Toast.LENGTH_SHORT
        ).show()
    }
}
