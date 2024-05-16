package com.example.lenslore
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ReportPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_report_post)

        val spinner: Spinner = findViewById(R.id.dropdown_report_post)
        val resources = this.resources
        val data = resources.getStringArray(R.array.report_reasons).toList()

        // Create an ArrayAdapter using your custom layout for both main view and dropdown
        val adapter = ArrayAdapter<String>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, data)
        adapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item) // Use custom layout for dropdown too
        spinner.adapter = adapter

        // Handle spinner selection (optional)
        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view : View?, pos: Int, id: Long) {
                val selectedReason = parent.getItemAtPosition(pos)
                Toast.makeText(this@ReportPostActivity, "Selected: $selectedReason", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                Toast.makeText(this@ReportPostActivity, "No reason selected", Toast.LENGTH_SHORT).show()
            }
        })

        //i have no idea why this is needed and whats the funciton
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*
        if (this is AdapterView.OnItemSelectedListener) {
            spinner.onItemSelectedListener = this as AdapterView.OnItemSelectedListener
            Toast.makeText(this, "Class implements OnItemSelectedListener", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Class does NOT implement OnItemSelectedListener", Toast.LENGTH_SHORT).show()
            // Handle the case where the class doesn'  t implement the listener
        }*/

    }
}
