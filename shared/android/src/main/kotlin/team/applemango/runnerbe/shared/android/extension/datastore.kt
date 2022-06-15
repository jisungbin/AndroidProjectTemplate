package team.applemango.runnerbe.shared.android.extension

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

// TODO
private const val DataStoreName = "TODO"

val Context.dataStore by preferencesDataStore(
    name = DataStoreName
)
