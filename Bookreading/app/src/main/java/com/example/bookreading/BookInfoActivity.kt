package com.example.bookreading

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BookInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book_info)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get data from intent
        val title = intent.getStringExtra("bookTitle")
        val description = intent.getStringExtra("bookDescription")
        val summary = intent.getStringExtra("bookSummary")
        val url = intent.getStringExtra("bookUrl")

        // Reference views
        val titleView = findViewById<TextView>(R.id.bookInfoTitle)
        val descriptionView = findViewById<TextView>(R.id.bookInfoDescription)
        val summaryView = findViewById<TextView>(R.id.bookInfoSummary)
        val readMoreButton = findViewById<Button>(R.id.readMoreButton)
        val backButton = findViewById<Button>(R.id.backToHomeButton)

        // Set data to views
        titleView.text = title ?: "No Title"
        descriptionView.text = description ?: "No Description Available"
        summaryView.text = summary ?: "No Summary Available"

        // Open book page in Chrome
        readMoreButton.setOnClickListener {
            if (!url.isNullOrEmpty()) {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
        }

        // Go back to home page
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
