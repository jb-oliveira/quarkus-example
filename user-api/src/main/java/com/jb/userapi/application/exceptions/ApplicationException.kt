package com.jb.userapi.application.exceptions

import java.lang.RuntimeException

open class ApplicationException(message: String?) : RuntimeException(message) {

}