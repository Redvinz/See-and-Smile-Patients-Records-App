package com.example.finalsprojectics26011

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

internal class MyDatabaseHelper(private val context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query =
            "CREATE TABLE " + TABLE_NAME +
                    " (" + COLUMN_NAME + " VARCHAR(100) PRIMARY KEY ," +
                    COLUMN_ADDRESS + " TEXT, " +
                    COLUMN_AGE + " TEXT, " +
                    COLUMN_CONTACT + " TEXT, " +
                    COLUMN_APPOINTMENT + " TEXT, " +
                    COLUMN_OD + " TEXT, " +
                    COLUMN_OS + " TEXT, " +
                    COLUMN_ADD + " TEXT, " +
                    COLUMN_PD + " TEXT, " +
                    COLUMN_FRAME + " TEXT, " +
                    COLUMN_LENS + " TEXT, " +
                    COLUMN_LABORATORY + " TEXT, " +
                    COLUMN_PRICE + " TEXT);"
        db.execSQL(query)
    }

    companion object {
        private const val DATABASE_NAME = "PatientRecord.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "patient_record"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_ADDRESS = "address"
        private const val COLUMN_AGE = "age"
        private const val COLUMN_CONTACT = "contact"
        private const val COLUMN_APPOINTMENT = "appointment"
        private const val COLUMN_OD = "od"
        private const val COLUMN_OS = "os"
        private const val COLUMN_ADD = "addition"
        private const val COLUMN_PD = "pd"
        private const val COLUMN_FRAME = "frame"
        private const val COLUMN_LENS = "lens"
        private const val COLUMN_LABORATORY = "lab"
        private const val COLUMN_PRICE = "price"
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addRecord(
        name: String?,
        address: String?,
        age: String?,
        contact: String?,
        appointment: String?,
        od: String?,
        os: String?,
        add: String?,
        pd: String?,
        frame: String?,
        lens: String?,
        laboratory: String?,
        price: String?
    ) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_NAME, name)
        cv.put(COLUMN_ADDRESS, address)
        cv.put(COLUMN_AGE, age)
        cv.put(COLUMN_CONTACT, contact)
        cv.put(COLUMN_APPOINTMENT, appointment)
        cv.put(COLUMN_OD, od)
        cv.put(COLUMN_OS, os)
        cv.put(COLUMN_ADD, add)
        cv.put(COLUMN_PD, pd)
        cv.put(COLUMN_FRAME, frame)
        cv.put(COLUMN_LENS, lens)
        cv.put(COLUMN_LABORATORY, laboratory)
        cv.put(COLUMN_PRICE, price)

        val result = db.insert(TABLE_NAME, null, cv)

        if (result == -1L) {
            Toast.makeText(context, "Record Insert Failed", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Record Successfully Inserted", Toast.LENGTH_LONG).show()
        }
    }


    fun readAllData(): Cursor? {
        val query = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db.rawQuery(query, null)
        }
        return cursor
    }
}
