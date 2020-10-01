package com.alejandrorios.expose.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * @author alejandrorios on 8/30/20
 */
typealias LocalStorageKey = String
typealias SharedPreferencesGetter = (Context) -> SharedPreferences
typealias StringResourceId = Int
typealias DeepLink = String
