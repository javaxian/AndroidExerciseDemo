package com.javaxian.applications.buildingservicesapp.utils

import android.util.Log

class DebugUtils {

    val DEBUG = true
    val LOG_TO_FILE = false

    companion object {
        private val DEBUG = true
        private val LOG_TO_FILE = false

        fun logInfo(text: String) {
            if (DEBUG)
                Log.i("DebugUtils", text)
        }

        fun logInfo(method: String, text: String) {
            if (DEBUG)
                Log.i(method, text)
        }

        fun logInfo(className: String, method: String, text: String) {
            if (DEBUG)
                Log.i("$className :: $method", text)
        }

        fun logError(text: String) {
            if (DEBUG)
                Log.e("DebugUtils", text)
        }

        fun logError(method: String, text: String) {
            if (DEBUG)
                Log.e(method, text)
        }

        fun logError(className: String, method: String, text: String) {
            if (DEBUG)
                Log.e("$className :: $method", text)
        }

        fun logDebug(text: String) {
            if (DEBUG)
                Log.d("DebugUtils", text)
        }

        fun logDebug(method: String, text: String) {
            if (DEBUG)
                Log.d(method, text)
        }

        fun logDebug(className: String, method: String, text: String) {
            if (DEBUG)
                Log.d("$className :: $method", text)
        }

        fun logThrowable(e: Throwable) {
            if (DEBUG) {
                Log.e("LogUtil", e.toString())
                e.printStackTrace()
                if (LOG_TO_FILE) {
                    logToFile(e)
                }
            }
        }

        fun logWarning(text: String) {
            if (DEBUG)
                Log.i("DebugUtils", text)
        }

        fun logWarning(method: String, text: String) {
            if (DEBUG)
                Log.i(method, text)
        }

        fun logToFile(e: Throwable) {
            try {
                val sb = StringBuffer(e.toString() + "\n")
                val stElements = e.stackTrace
                var newLine = ""

                for (stElement in stElements) {
                    sb.append(newLine)
                    sb.append("\tat ")
                    sb.append(stElement.toString())
                    newLine = "\n"
                }
            } catch (ee: Exception) {
                e.printStackTrace()
            }

        }
    }


}