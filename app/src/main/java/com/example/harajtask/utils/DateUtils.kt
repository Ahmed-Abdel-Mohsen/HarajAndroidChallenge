package com.example.harajtask.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {
        private const val SECOND_MILLIS: Long = 1000
        private const val MINUTE_MILLIS: Long = 60 * SECOND_MILLIS
        private const val HOUR_MILLIS: Long = 60 * MINUTE_MILLIS

        private val sdf: DateFormat = SimpleDateFormat("d MMM", Locale.ENGLISH)
        private val sdfY: DateFormat = SimpleDateFormat("d MMM yyyy", Locale.ENGLISH)
        private val sdfFullDate: DateFormat = SimpleDateFormat("yyyy/MM/dd h:mmaa", Locale.ENGLISH)

        fun getTimeString(timestamp_: Long): String {
            var timestamp = timestamp_

            if (timestamp < 1000000000000L) {
                timestamp *= 1000
            }
            val today: Calendar = Calendar.getInstance()

            val timeCal: Calendar = Calendar.getInstance()
            timeCal.timeInMillis = timestamp

            val now = System.currentTimeMillis()
            if (timestamp > now || timestamp <= 0) {
                return ""
            }

            val diff: Long = now - timestamp
            return when {
                diff < MINUTE_MILLIS -> {
                    "Just now"
                }
                diff < 2 * MINUTE_MILLIS -> {
                    "Since 1 minute"
                }
                diff < 59 * MINUTE_MILLIS -> {
                    "Since " + (diff / MINUTE_MILLIS).toString() + " minutes"
                }
                diff < 2 * HOUR_MILLIS -> {
                    "Since 1 hour"
                }
                diff < 24 * HOUR_MILLIS -> {
                    "Since " + (diff / HOUR_MILLIS).toString() + " hours"
                }
                diff < 48 * HOUR_MILLIS -> {
                    "Since yesterday"
                }
                today.get(Calendar.YEAR) == timeCal.get(Calendar.YEAR) -> {
                    "Since " + sdf.format(timeCal.time)
                }
                else -> {
                    "Since" + sdfY.format(timeCal.time)
                }
            }
        }

        fun getSpecificDate(timestamp_: Long) : String{
            var timestamp = timestamp_

            if (timestamp < 1000000000000L) {
                timestamp *= 1000
            }

            val timeCal: Calendar = Calendar.getInstance()
            timeCal.timeInMillis = timestamp

            val now = System.currentTimeMillis()
            if (timestamp > now || timestamp <= 0) {
                return ""
            }

            return sdfFullDate.format(timeCal.time)
        }
    }
}