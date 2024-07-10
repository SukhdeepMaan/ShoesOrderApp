package com.example.abcapp.notifications

import com.example.abcapp.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

data class NotificationData (
     val id : Int,
     val image : Int,
     val title : String,
     val description : String,
     val time : String,
     var isRead : Boolean,
     val topPrice : Double,
     val bottomPrice : Double,
     val type:String
 )

var notificationList = listOf(
    NotificationData(
        id = 1,
        image = R.drawable.nike_list_image,
        title = "Nike Air Max",
        description = "Nike Air Max 97",
        time = "2024-07-10 09:12:00",
        isRead = false,
        topPrice = 897.00,
        bottomPrice = 493.00,
        type = "Today"
    ),
    NotificationData(
        id = 2,
        image = R.drawable.nike_list_image,
        title = "Nike Air Max",
        description = "Nike Air Max 97",
        time = "2024-07-10 04:30:00",
        isRead = false,
        topPrice = 897.00,
        bottomPrice = 493.00,
        type = "Today"
    ),
    NotificationData(
        id = 3,
        image = R.drawable.nike_list_image,
        title = "Nike Air Max",
        description = "Nike Air Max 97",
        time = "2024-07-09 11:30:00",
        isRead = false,
        topPrice = 897.00,
        bottomPrice = 493.00,
        type = "Today"
    ),
    NotificationData(
        id = 4,
        image = R.drawable.nike_list_image,
        title = "Nike Air Max",
        description = "Nike Air Max 97",
        time = "2024-07-06 14:30:00",
        isRead = false,
        topPrice = 897.00,
        bottomPrice = 493.00,
        type = "Today"
    ),
    NotificationData(
        id = 5,
        image = R.drawable.nike_list_image,
        title = "Nike Air Max",
        description = "Nike Air Max 97",
        time = "2024-07-05 14:30:00",
        isRead = false,
        topPrice = 897.00,
        bottomPrice = 493.00,
        type = "Today"
    ),
    NotificationData(
        id = 6,
        image = R.drawable.nike_list_image,
        title = "Nike Air Max",
        description = "Nike Air Max 97",
        time = "2024-07-04 14:30:00",
        isRead = false,
        topPrice = 897.00,
        bottomPrice = 493.00,
        type = "Yesterday"
    ),
    NotificationData(
        id = 7,
        image = R.drawable.nike_list_image,
        title = "Nike Air Max",
        description = "Nike Air Max 97",
        time = "2024-07-03 14:30:00",
        isRead = false,
        topPrice = 897.00,
        bottomPrice = 493.00,
        type = "Yesterday"
    ),
    NotificationData(
        id = 8,
        image = R.drawable.nike_list_image,
        title = "Nike Air Max",
        description = "Nike Air Max 97",
        time = "2024-07-02 14:30:00",
        isRead = false,
        topPrice = 897.00,
        bottomPrice = 493.00,
        type = "Yesterday"
    ),
    NotificationData(
        id = 9,
        image = R.drawable.nike_list_image,
        title = "Nike Air Max",
        description = "Nike Air Max 97",
        time = "2024-07-01 14:30:00",
        isRead = false,
        topPrice = 897.00,
        bottomPrice = 493.00,
        type = "Yesterday"
    ),
    NotificationData(
        id = 10,
        image = R.drawable.nike_list_image,
        title = "Nike Air Max",
        description = "Nike Air Max 97",
        time = "2023-06-01 14:30:00",
        isRead = false,
        topPrice = 897.00,
        bottomPrice = 493.00,
        type = "Yesterday"
    )
)

fun formatTimeDifference(notificationTime: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val notificationDateTime = LocalDateTime.parse(notificationTime, formatter)
    val currentTime = LocalDateTime.now()

    val minutes = ChronoUnit.MINUTES.between(notificationDateTime, currentTime)
    val hours = ChronoUnit.HOURS.between(notificationDateTime, currentTime)
    val days = ChronoUnit.DAYS.between(notificationDateTime, currentTime)
    val months = ChronoUnit.MONTHS.between(notificationDateTime, currentTime)
    val years = ChronoUnit.YEARS.between(notificationDateTime, currentTime)

    return when {
        minutes < 60 -> "$minutes minutes ago"
        hours < 24 -> "$hours hours ago"
        days < 30 -> "$days days ago"
        years > 0 -> "$years years ago"
        else -> "$months months ago"
    }
}
