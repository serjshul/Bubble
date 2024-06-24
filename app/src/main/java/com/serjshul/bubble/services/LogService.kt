package com.serjshul.bubble.services

interface LogService {
    fun logNonFatalCrash(throwable: Throwable): Int
}