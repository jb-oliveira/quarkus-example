package org.jb.userapi.domain

import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    var street: String,
    var city: String,
    var state: String,
    var zip: String
)