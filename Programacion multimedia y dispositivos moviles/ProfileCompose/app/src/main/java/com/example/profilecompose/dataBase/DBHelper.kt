package com.example.profilecompose.dataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.compose.material3.Text

class DBHelper (context: Context, factory: SQLiteDatabase.CursorFactory):
    SQLiteOpenHelper(){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE  $TABLE_NAME(
            $ID_COL INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
            $NAME_COL TEXT,
            $PASSWORD_COL TEXT
            )
        """.trimIndent()
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addUser(name: String, password: String){
        val values = ContentValues().apply {
            put(NAME_COL, name)
            put(PASSWORD_COL, password)
        }

        writableDatabase.use { db->
            db.insert(TABLE_NAME, null, values)
        }
    }

    fun getCountOfUser(name: String?, password: String?): Boolean{
        val cursor = readableDatabase.rawQuery("SELECT * FROM $TABLE_NAME", null)
        val count = cursor.count
        cursor.close()
        return count
    }
}
