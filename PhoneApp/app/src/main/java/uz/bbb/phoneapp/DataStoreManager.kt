package uz.bbb.phoneapp

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.json.JSONObject

val Context.dataStore by preferencesDataStore("phones_data")

class DataStoreManager(private val context: Context) {

    suspend fun savePhoneToBrand(brand: String, name: String, features: String) {
        val key = stringPreferencesKey(brand)
        context.dataStore.edit { prefs ->
            val existing = prefs[key] ?: "{}"
            val json = JSONObject(existing)
            json.put(name, features)
            prefs[key] = json.toString()
        }
    }

    suspend fun getBrands(): List<String> {
        return context.dataStore.data.map { prefs ->
            prefs.asMap().keys.map { it.name }
        }.first()
    }

    suspend fun getPhoneModelsForBrand(brand: String): List<String> {
        val key = stringPreferencesKey(brand)
        val data = context.dataStore.data.map { prefs -> prefs[key] ?: "{}" }.first()
        val json = JSONObject(data)
        return json.keys().asSequence().toList()
    }

    suspend fun getPhoneInfoForBrand(brand: String): String {
        val key = stringPreferencesKey(brand)
        val data = context.dataStore.data.map { prefs -> prefs[key] ?: "{}" }.first()
        return data
    }
}
