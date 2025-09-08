package uz.bbb.contactapp.db

import uz.bbb.contactapp.models.Contact

interface DatabaseService {
    fun addContact(contact: Contact)

    fun deleteContact(contact: Contact)

    fun updateContact(contact: Contact): Int

    fun getAllContacts(): List<Contact>
}