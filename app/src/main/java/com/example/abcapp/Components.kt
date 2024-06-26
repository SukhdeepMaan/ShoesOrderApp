package com.example.abcapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.abcapp.ui.theme.white

var mapList = mapOf(
    R.drawable.nike to "Nike",
    R.drawable.adidas to "Adidas",
    R.drawable.puma to "Puma",
    R.drawable.converse to "Converse",
    R.drawable.under_armour to "Under Armour",
)

// header like AppBar
@Composable
fun HeaderDesign(
    modifier: Modifier = Modifier,
    title: @Composable (ColumnScope.() -> Unit)? = null,
    leadingIcon: @Composable RowScope.() -> Unit = {},
    trailingIcon: @Composable RowScope.() -> Unit = {},
) {
    Row(
        modifier = modifier
            .requiredHeight(64.dp)
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        leadingIcon.invoke(this)
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            title?.invoke(this)
        }
        trailingIcon.invoke(this)
    }
}


// custom Icon

@Composable
fun CustomIcon(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    background: Boolean = true,
    contentDescription: String,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .drawBehind {
                if (background) {
                    drawCircle(
                        color = Color.White
                    )
                }
            },
        onClick = onClick
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = contentDescription
        )
    }
}


// search bar

@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Unspecified,
            unfocusedIndicatorColor = Color.Unspecified,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
        ),
        shape = CircleShape

    )
}


// company list design


@Preview(showBackground = true)
@Composable
private fun CompanyNameView() {

    CompanyNameButton(
        modifier = Modifier.padding(8.dp),
        icon = R.drawable.nike,
        name = "Nike",
        index = 0,
        isSelected = false
    ) {

    }
}

@Composable
fun CompanyNameButton(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    name: String,
    index: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    if (isSelected) {
        Button(
            modifier = modifier.height(64.dp),
            shape = ButtonDefaults.shape,
            contentPadding = ButtonDefaults.ContentPadding,
            onClick = onClick
        ) {
            CustomIcon(
                icon = icon,
                contentDescription = name,
                onClick = onClick
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = name)
        }

    } else {
        CustomIcon(
            modifier = modifier.fillMaxHeight(),
            icon = icon,
            contentDescription = name,
            onClick = onClick
        )
    }

}