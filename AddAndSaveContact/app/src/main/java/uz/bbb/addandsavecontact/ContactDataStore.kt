package uz.bbb.addandsavecontact

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// DataStore ni e’lon qilish
val Context.dataStore by preferencesDataStore("Contacts")

object ContactDataStore {
    private val CONTACT_LIST = stringSetPreferencesKey("contact_list")

    suspend fun saveContact(context: Context, name: String, phone: String) {
        context.dataStore.edit { prefs ->
            val oldData = prefs[CONTACT_LIST] ?: emptySet()
            val newData = oldData.toMutableSet()
            newData.add("$name\n$phone")
            prefs[CONTACT_LIST] = newData
        }
    }

    fun getContacts(context: Context): Flow<Set<String>> {
        return context.dataStore.data.map { prefs ->
            prefs[CONTACT_LIST] ?: emptySet()
        }
    }

    suspend fun clearContacts(context: Context) {
        context.dataStore.edit { prefs ->
            prefs.remove(CONTACT_LIST)
        }
}
}
