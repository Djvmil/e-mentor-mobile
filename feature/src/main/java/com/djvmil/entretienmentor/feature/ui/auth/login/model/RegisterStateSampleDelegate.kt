package com.djvmil.entretienmentor.feature.ui.auth.login.model

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

data class RegisterStateSampleDelegate(
    val usernameInput: String = "",
    val passwordInput: String = "",
    val isInputValid: Boolean = false,
    val isPasswordShown: Boolean = false,
    val errorUsernameInput: String? = null,
    val isLoading: Boolean = false,
    val isSuccessfullyLoggedIn: Boolean = false,
    val errorMessageLoginProcess: String? = null
): ReadWriteProperty<String, String>, ReadOnlyProperty<String, String> {

    private var username = usernameInput
    override fun getValue(thisRef: String, property: KProperty<*>): String {
        return username
    }

    override fun setValue(thisRef: String, property: KProperty<*>, value: String) {
        username = thisRef
    }
}

data class RegisterStateSampleDelegate2(
    val usernameInput: String = "",
    val passwordInput: String = "",
    val isInputValid: Boolean = false,
    val isPasswordShown: Boolean = false,
    val errorUsernameInput: String? = null,
    val isLoading: Boolean = false,
    val isSuccessfullyLoggedIn: Boolean = false,
    val errorMessageLoginProcess: String? = null
): ReadOnlyProperty<String, String> {

    private var username = usernameInput
    override fun getValue(thisRef: String, property: KProperty<*>): String {
        return username
    }

}