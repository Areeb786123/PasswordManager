package com.areeb.passwordmanager.utils.hashing

import org.mindrot.jbcrypt.BCrypt

fun String.toHash(): String? {
    val salt = BCrypt.gensalt()
    // Hash the string using bcrypt
    return BCrypt.hashpw(this, salt)
}