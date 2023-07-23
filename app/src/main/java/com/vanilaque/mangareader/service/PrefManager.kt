package com.vanilaque.mangareader.service

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import com.google.gson.Gson
import com.vanilaque.mangareader.data.model.Provider
import com.vanilaque.mangareader.presentation.components.FooterPath
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class PrefManager @Inject constructor(context: Context) {
    companion object {
        const val PREF_NAME = "regioapp.prefs"
        const val FOOTER_PATH = "footer_path"
        const val CHOSEN_PROVIDER = "chosen_provider"
    }

    private val shared: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var chosenProvider: Provider?
        get() = Gson().fromJson(
            shared.getString(CHOSEN_PROVIDER, Gson().toJson(null)),
            Provider::class.java
        )
        set(value) = shared.edit {
            putString(CHOSEN_PROVIDER, Gson().toJson(value))
        }

    var footerPath: FooterPath?
        get() = Gson().fromJson(
            shared.getString(FOOTER_PATH, Gson().toJson(FooterPath.CATALOG)),
            FooterPath::class.java
        )
        set(value) = shared.edit {
            putString(FOOTER_PATH, Gson().toJson(value))
        }
}