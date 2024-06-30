package com.example.abcapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.data.ShoeData
import com.example.abcapp.data.shoeList
import com.example.abcapp.ui.theme.cornflowerBlue


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
            colors = ButtonDefaults.buttonColors(
                containerColor = cornflowerBlue,
            ),
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

@Composable
fun StickyHeaderDesign(
    modifier: Modifier = Modifier,
    header: String,
    buttonName: String = "See all",
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = header,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        TextButton(
            onClick = onClick,
            colors = ButtonDefaults.textButtonColors(
                contentColor = cornflowerBlue,
            )
        ) {
            Text(text = buttonName)
        }
    }
}


@Composable
fun ShoeItem(
    modifier: Modifier = Modifier,
    shoeData: ShoeData,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .size(180.dp, 280.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(start = 8.dp)

    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit,
            painter = painterResource(id = shoeData.image),
            contentDescription = shoeData.name
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = shoeData.description,
            color = cornflowerBlue,
            style = TextStyle(
                fontSize = 12.sp
            )
        )
        Text(
            modifier = Modifier.padding(vertical = 4.dp),
            text = shoeData.name,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "$${shoeData.price}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Button(
                onClick = onClick,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = cornflowerBlue,
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
private fun ab() {
    NewShowItem(shoeData = shoeList[1])
}

// NewShowItem
@Composable
fun NewShowItem(
    modifier: Modifier = Modifier,
    shoeData: ShoeData
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(start = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ){
            Text(
                text = shoeData.description,
                color = cornflowerBlue,
                style = TextStyle(
                    fontSize = 14.sp
                )
            )
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = shoeData.name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "$${shoeData.price}",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
        Image(
            modifier = Modifier
                .weight(1f)
                .size(150.dp),
            contentScale = ContentScale.Fit,
            painter = painterResource(id = shoeData.image),
            contentDescription = shoeData.name
        )
    }

}