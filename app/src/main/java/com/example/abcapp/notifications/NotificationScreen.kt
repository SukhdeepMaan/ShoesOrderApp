package com.example.abcapp.notifications

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.abcapp.Circle
import com.example.abcapp.CustomIcon
import com.example.abcapp.HeaderDesign
import com.example.abcapp.R
import com.example.abcapp.ui.theme.cornflowerBlue
import com.example.abcapp.ui.theme.lightGreyForBackGround
import com.example.abcapp.ui.theme.unselectedTextColor

@Composable
fun NotificationScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    NotificationScreenDesign(
        modifier = modifier,
        header = {
            HeaderDesign(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
                title = {
                    Text(
                        text = stringResource(R.string.notifications),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                },
                leadingIcon = {
                    CustomIcon(
                        icon = R.drawable.arrow,
                        contentDescription = stringResource(R.string.back),
                        onClick = {
                            navHostController.popBackStack()
                        }
                    )
                },
                trailingIcon = {
                    TextButton(
                        onClick = {
                            // clear all
                        },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = cornflowerBlue
                        )
                    ) {
                        Text(text = stringResource(R.string.clear_all))
                    }
                }
            )

        },
        content = {
            val groupItem = notificationList.groupBy { it.type }
            //map[0] -> today,list of data
            // map[1] -> yesterday , list of data
            groupItem.forEach { (type,data)->
                item {
                    Text(
                        text = type,
                        modifier.padding(start = 20.dp, top = 8.dp),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
                items(data, key = {it.id}){
                    NotificationItem(notificationData = it) {
                    }
                }
            }
        }
    )
}


@Composable
private fun NotificationScreenDesign(
    modifier: Modifier = Modifier, header: @Composable () -> Unit,
    content: LazyListScope.() -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = lightGreyForBackGround)
    ) {
        header.invoke()
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            content.invoke(this)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NotificationItemView() {
    NotificationItem(notificationData = notificationList[0])
}

@Composable
private fun NotificationItem(
    modifier: Modifier = Modifier,
    notificationData: NotificationData,
    onItemClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .height(intrinsicSize = IntrinsicSize.Min)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.Top
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = notificationData.image),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
            )
            TitleDesAndPrice(
                isRead = notificationData.isRead,
                title = notificationData.title,
                description = notificationData.description,
                topPrice = notificationData.topPrice,
                bottomPrice = notificationData.bottomPrice
            )
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = formatTimeDifference(notificationData.time),
                style = TextStyle(
                    fontSize = 12.sp
                )
            )
            if (!notificationData.isRead) {
                Circle(
                    modifier = Modifier.padding(top = 16.dp),
                    color = cornflowerBlue,
                    size = 8
                )
            }
        }
    }
}

@Composable
private fun TitleDesAndPrice(
    modifier: Modifier = Modifier,
    isRead: Boolean = false,
    title: String,
    description: String,
    topPrice: Double,
    bottomPrice: Double
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // title
        Text(
            text = title,
            style = TextStyle(
                fontWeight = if (isRead) FontWeight.Normal else FontWeight.SemiBold,
                fontSize = if (isRead) 16.sp else 18.sp
            )
        )
        // description
        Text(
            text = description,
            style = TextStyle(
                fontWeight = if (isRead) FontWeight.Normal else FontWeight.SemiBold
            )
        )
        // prices
        Row(
            modifier = Modifier.fillMaxHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$${topPrice}",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = "$${bottomPrice}",
                style = TextStyle(
                    color = unselectedTextColor,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}