package com.main.core.exception

abstract class ApplicationException(message: String): Exception(message)

class AudioException(message: String): ApplicationException(message)