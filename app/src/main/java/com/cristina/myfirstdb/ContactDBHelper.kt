package com.cristina.myfirstdb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val  version = 1

class ContactDBHelper(context : Context) : SQLiteOpenHelper(context, DB_NAME, null, version) {

    val createContactTable = "CREATE TABLE $TABLE_NAME_CONTACT" +
            "(ID INTEGER PRIMARY KEY," +
            "$COLUMN_NAME TEXT," +
            "$COLUM_LASTNAME TEXT," +
            "$COLUM_AGE INTEGER);"

    val deleteContactTable = "DROP TABLE IF EXISTS $TABLE_NAME_CONTACT"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createContactTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(createContactTable)
        onCreate(db)
    }
}