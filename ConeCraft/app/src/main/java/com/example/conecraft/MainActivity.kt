package com.example.conecraft

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var flavorOneSpinner: Spinner
    lateinit var flavorTwoSpinner: Spinner
    lateinit var mixScoopButton: Button
    lateinit var instructionButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val flavors = arrayOf("Vanilla", "Chocolate", "Strawberry", "Mango", "Pistachio")


            flavorOneSpinner = findViewById(R.id.Flavorone)
            flavorTwoSpinner = findViewById(R.id.flavortwo)
            mixScoopButton = findViewById(R.id.MixscoopButton)
            instructionButton = findViewById(R.id.InstructionButton)

            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, flavors)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            flavorOneSpinner.adapter = adapter
            flavorTwoSpinner.adapter = adapter

            mixScoopButton.setOnClickListener {
                val flavor1 = flavorOneSpinner.selectedItem.toString()
                val flavor2 = flavorTwoSpinner.selectedItem.toString()
                showMixPopup(flavor1, flavor2)
            }

            instructionButton.setOnClickListener {
                showInstructionPopup()
            }
        }

        fun showMixPopup(flavor1: String, flavor2: String) {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.popup_mix)
            dialog.setCancelable(false)

            dialog.window?.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )

            val resultText = dialog.findViewById<TextView>(R.id.resultText)
            val closeBtn = dialog.findViewById<Button>(R.id.closeButton)

            resultText.text = "Your $flavor1 and $flavor2 cone is ready!"

            closeBtn.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }

        fun showInstructionPopup() {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.popup_instruction)
            dialog.setCancelable(false)

            dialog.window?.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )

            val closeBtn = dialog.findViewById<Button>(R.id.instructionCloseButton)
            closeBtn.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }
    }


