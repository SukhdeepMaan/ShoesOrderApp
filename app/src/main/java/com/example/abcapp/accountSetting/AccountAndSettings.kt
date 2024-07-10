package com.example.abcapp.accountSetting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.CustomIcon
import com.example.abcapp.HeaderDesign
import com.example.abcapp.R
import com.example.abcapp.ui.theme.cornflowerBlue
import com.example.abcapp.ui.theme.lightGreyForBackGround
import com.example.abcapp.ui.theme.unselectedColor

@Composable
private fun AccountAndSettingsDesign(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    content: LazyListScope.() -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = lightGreyForBackGround)
            .padding(horizontal = 20.dp)
    ) {
        header.invoke()
        LazyColumn(modifier = modifier) {
            content.invoke(this)
        }
    }
}

@Composable
fun AccountAndSettings(modifier: Modifier = Modifier) {

    var appSettingsListMutable by remember {
        mutableStateOf(appSettingsList)
    }
    AccountAndSettingsDesign(
        modifier = modifier,
        header = {
            HeaderDesign(
                modifier = Modifier.padding(vertical = 12.dp),
                title = {
                    Text(
                        text = "Account & Settings",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                },
                leadingIcon = {
                    CustomIcon(
                        icon = R.drawable.arrow,
                        contentDescription = "Arrow",
                        onClick = { /*TODO*/ }
                    )
                }
            )

        },
        content = {
            item {
                Text(
                    text = "Account",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(vertical = 24.dp)
                )
            }
            items(accountFeatureList, key = { it.name }) {
                AccountListItem(
                    account = it,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                HorizontalDivider(
                    color = unselectedColor
                )
            }
            item {
                Text(
                    text = "App Settings",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(vertical = 24.dp)
                )
            }
            items(appSettingsListMutable, key = { it.name }) { it ->
                AppSettingsItem(
                    appSettings = it,
                    modifier = Modifier.padding(vertical = 16.dp)
                ) { appSettings->
                    // update the state
                    appSettingsListMutable = appSettingsListMutable.map {
                        if (it.name == appSettings.name) {
                            it.copy(isSelected = appSettings.isSelected)
                        } else {
                            it
                        }
                    }
                }
                HorizontalDivider(
                    color = unselectedColor
                )
            }
        }
    )
}

@Composable
private fun AccountListItem(
    modifier: Modifier = Modifier,
    account: Account
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(end = 12.dp),
                painter = painterResource(id = account.icon),
                contentDescription = ""
            )
            Text(text = account.name)
        }

        Icon(
            painter = painterResource(id = R.drawable.forword_arrow),
            contentDescription = ""
        )
    }
}

@Composable
fun AppSettingsItem(
    modifier: Modifier = Modifier,
    appSettings: AppSettings,
    onToggle: (AppSettings) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = appSettings.name,
            modifier.weight(1f)
        )
        Switch(
            checked = appSettings.isSelected, onCheckedChange = {
                onToggle(appSettings.copy(isSelected =  it))
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                uncheckedThumbColor = Color.White,
                checkedTrackColor = cornflowerBlue,
                uncheckedTrackColor = unselectedColor,
                uncheckedBorderColor = Color.Unspecified
            )
        )
    }
}
