package com.example.bookreading

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Click listeners for ImageButtons
        val imageButton1 = findViewById<ImageButton>(R.id.imageButton)
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        val imageButton3 = findViewById<ImageButton>(R.id.imageButton3)
        val imageButton4 = findViewById<ImageButton>(R.id.imageButton4)

        imageButton1.setOnClickListener {
            openBookInfo(
                "Atomic Habits",
                "Published in 2018, this book teaches how to build good habits and break bad ones.",
                "James Clear presents a practical framework for improving your life every day. It emphasizes identity-based habits, the 4 laws of behavior change, and how small consistent steps lead to massive transformation. This book reveals how tiny changes make a big difference in life.\n" +
                        "James Clear explains the power of identity-based habits and the 4 laws of behavior change.\n" +
                        "It focuses on building systems instead of setting vague goals.\n" +
                        "You’ll learn how consistent small improvements lead to remarkable results over time.",
                "https://jamesclear.com/atomic-habits"
            )
        }

        imageButton2.setOnClickListener {
            openBookInfo(
                "How to Win Friends and Influence People",
                "A timeless classic by Dale Carnegie focusing on communication and relationship skills.",
                "This book gives timeless advice on how to make people like you, win others to your way of thinking, and change people without resentment. It's been influencing lives since 1936. A classic guide to effective communication and influence.\n" +
                        "It teaches how to make people feel valued, respected, and heard.\n" +
                        "The book is filled with real-life examples and timeless social principles.\n" +
                        "It's a must-read for personal and professional relationship-building.\n" +
                        "\n",
                "https://en.wikipedia.org/wiki/How_to_Win_Friends_and_Influence_People"
            )
        }

        imageButton3.setOnClickListener {
            openBookInfo(
                "Rich Dad Poor Dad",
                "This book explores financial literacy and wealth-building mindset.",
                "Robert Kiyosaki compares his two 'dads' — one rich, one poor — to teach lessons on money, investing, and financial independence. A must-read for financial education. This book compares the financial mindsets of Kiyosaki’s two “dads.”\n" +
                        "It emphasizes financial education, investing, and escaping the rat race.\n" +
                        "The core lesson is to make money work for you, not the other way around.\n" +
                        "A foundational read for those seeking long-term financial freedom.\n" +
                        "\n",
                "https://www.richdad.com/products/rich-dad-poor-dad"
            )
        }

        imageButton4.setOnClickListener {
            openBookInfo(
                "The Psychology of Money",
                "Explores the emotional and psychological aspects of money management.",
                "Morgan Housel shares 19 short stories exploring how people think about money, emphasizing behavior over math. It shows why doing well with money has more to do with how you act than what you know. This book explores how emotions, behavior, and mindset affect our financial decisions.\n" +
                        "It shares 19 lessons on the irrational and human side of money.\n" +
                        "Housel emphasizes that doing well financially isn’t about knowledge—but behavior.\n" +
                        "Simple, relatable stories make complex money concepts easy to understand.\n" +
                        "\n",
                "https://www.goodreads.com/book/show/41881472-the-psychology-of-money"
            )
        }
        val instructionButton = findViewById<Button>(R.id.instructionButton)
        instructionButton.setOnClickListener {
            val intent = Intent(this, InstructionActivity::class.java)
            startActivity(intent)
        }

    }

    private fun openBookInfo(title: String, description: String, summary: String, url: String) {
        val intent = Intent(this, BookInfoActivity::class.java)
        intent.putExtra("bookTitle", title)
        intent.putExtra("bookDescription", description)
        intent.putExtra("bookSummary", summary)
        intent.putExtra("bookUrl", url)
        startActivity(intent)
    }
}
