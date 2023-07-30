package org.jb.userapi.domain

enum class UserStatus {
    Active,
    Inactive;

    companion object {
        fun fromString(status: String): UserStatus {
            return values().find { it.name.equals(status, ignoreCase = true) }
                ?: throw IllegalArgumentException("Invalid status: $status")
        }
    }
}
