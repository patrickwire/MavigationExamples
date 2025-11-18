package de.patrickwire.myapplication.mavigationexamples.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

object SettingsDataStore {
    private val INPUT_TEXT_KEY = stringPreferencesKey("input_text")

    fun getInputText(context: Context): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[INPUT_TEXT_KEY] ?: ""
        }
    }

    suspend fun saveInputText(context: Context, text: String) {
        context.dataStore.edit { preferences ->
            preferences[INPUT_TEXT_KEY] = text
        }
    }
}
