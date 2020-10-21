package com.cristina.myfirstdb

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class AddContact : AppCompatActivity() {

    private lateinit var contactDBHelper : ContactDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        contactDBHelper = ContactDBHelper(this)

        val buttonSave = findViewById<MaterialButton>(R.id.button_save)
        val editTextName = findViewById<TextInputEditText>(R.id.textinput_name)
        val editTextLastName = findViewById<TextInputEditText>(R.id.textinput_lastname)
        val editTextAge = findViewById<TextInputEditText>(R.id.textinput_age)

        buttonSave.setOnClickListener { view ->
            val db = contactDBHelper.writableDatabase
            db.use {
                val contentValues = ContentValues()

                contentValues.put(COLUMN_NAME, editTextName.text.toString())
                contentValues.put(COLUM_LASTNAME,editTextLastName.text.toString())
                contentValues.put(COLUM_AGE,editTextAge.text.toString().toInt())

                db.insert(TABLE_NAME_CONTACT, null,contentValues)

                val snackBar = Snackbar.make(view.rootView,"Contacto guardo",Snackbar.LENGTH_SHORT)
                snackBar.show()
            }
        }
    }
}