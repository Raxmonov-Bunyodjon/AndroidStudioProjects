package uz.bbb.contactapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import uz.bbb.contactapp.models.Contact
import uz.bbb.contactapp.utils.Constant

class MyDbHelper(context: Context): SQLiteOpenHelper(context, Constant.DB_NAME,null, Constant.DB_VERSION), DatabaseService {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "create table ${Constant.TABLE_NAME} (${Constant.ID} integer not null primary key autoincrement unique, ${Constant.NAME} text not null , ${Constant.PHONE_NUMBER} text not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("drop table if exists ${Constant.TABLE_NAME}")
        onCreate(db)

    }

    override fun addContact(contact: Contact) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constant.NAME, contact.name)
        contentValues.put(Constant.PHONE_NUMBER, contact.phoneNumber)
        database.insert(Constant.TABLE_NAME,null,contentValues)
        database.close()
    }

    override fun deleteContact(contact: Contact) {
        val database = this.writableDatabase
        database.delete(Constant.TABLE_NAME,"${Constant.ID} = ?", arrayOf("${contact.id}"))
        database.close()
    }

    override fun updateContact(contact: Contact): Int {
        val database = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(Constant.ID, contact.id)
        contentValues.put(Constant.NAME, contact.name)
        contentValues.put(Constant.PHONE_NUMBER, contact.phoneNumber)
        return database.update(Constant.TABLE_NAME,
            contentValues,
            "${Constant.ID} = ?",
            arrayOf(contact.id.toString()))
    }

    override fun getAllContacts(): List<Contact> {
        val list = ArrayList<Contact>()
        val query = "SELECT * FROM ${Constant.TABLE_NAME}"
        val readableDatabase = this.readableDatabase
        val cursor = readableDatabase.rawQuery(query, null)

        if (cursor.moveToFirst()) { // moveToNext emas, moveToFirst bo‘lishi kerak
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val phone = cursor.getString(2)
                val contact = Contact(id, name, phone)
                list.add(contact)
            } while (cursor.moveToNext())
        }
        cursor.close()
        readableDatabase.close()
        return list
    }


}