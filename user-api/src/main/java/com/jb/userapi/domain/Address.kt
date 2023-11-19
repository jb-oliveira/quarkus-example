package com.jb.userapi.domain

import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    var street: String? = null,
    var city: String? = null,
    var state: String? = null,
    var zip: String? = null
)