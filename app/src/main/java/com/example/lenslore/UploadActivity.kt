package com.example.lenslore

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.content.Intent
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class UploadActivity : AppCompatActivity(), TextWatcher {
    private val REQUEST_IMAGE_CAPTURE = 1

    private var captionText: EditText? = null
    private var characterCount: TextView? = null
    private val characterLimit = 50 // Define the character limit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        // Find your EditText and TextView elements
        captionText = findViewById(R.id.caption_text)
        characterCount = findViewById(R.id.character_count)

        // Register the TextWatcher with the EditText
        captionText?.addTextChangedListener(this)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        // Optional: Do something before the text changes
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        val currentLength = s.toString().length
        val remainingChars = characterLimit - currentLength

        // Update the character count TextView
        characterCount!!.text = "$remainingChars/$characterLimit"

        // Check if character limit is exceeded
        if (currentLength > characterLimit) {
            // Remove exceeding characters
            captionText!!.getText().delete(characterLimit, currentLength)
            Toast.makeText(this, "Character limit reached!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun afterTextChanged(s: Editable) {
        // Optional: Do something after the text changes
    }


    fun onCamera(view: View) {
        // Create an intent to capture images
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            // Start the image capture intent
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } else {
            // Display a toast if there's no camera app available
            Toast.makeText(this, "No camera app available", Toast.LENGTH_SHORT).show()
        }
    }
    //create intent for opening camera
    //create intent for opening gallery to choose photo to post
}
