package com.example.abcapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.stringResource
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

data class Shoes(
    val id: Int,
    val name: String,
    @DrawableRes val icon: Int
)

object DataModel {

    fun getShoesData() = listOf(
        Shoes(1, "Nike", R.drawable.nike),
        Shoes(2, "Adidas", R.drawable.adidas),
        Shoes(3, "Puma", R.drawable.puma),
        Shoes(4, "Converse", R.drawable.converse),
        Shoes(5, "Under Armour", R.drawable.under_armour)
    )

}

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
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        leadingIcon.invoke(this)
        Column(
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
    tint: Color = Color.Unspecified,
    onClick: () -> Unit = {}
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
        Icon(
            painter = painterResource(id = icon),
            contentDescription = contentDescription,
            tint = tint
        )
    }
}

@Composable
fun Circle(modifier: Modifier = Modifier, color: Color = Color.Red) {
    Spacer(
        modifier = modifier
            .background(color, CircleShape)
            .size(8.dp)
    )
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
    data: Shoes,
    index: Int,
    isSelected: Boolean,
    onClick: (Int) -> Unit
) {
    Button(
        modifier = modifier,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) cornflowerBlue else Color.White,
        ),
        onClick = { onClick(index) },
        contentPadding = if (isSelected) PaddingValues(
            top = 10.dp, bottom = 10.dp, start = 10.dp, end = 30.dp
        ) else PaddingValues(10.dp)
    ) {
        if (isSelected) {
            CustomIcon(
                icon = data.icon,
                contentDescription = data.name,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = data.name)
        } else {
            Icon(
                painter = painterResource(id = data.icon),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(45.dp)
            )
        }
    }
}

@Composable
fun StickyHeaderDesign(
    modifier: Modifier = Modifier,
    header: String,
    buttonName: String = stringResource(R.string.see_all),
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp),
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
                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    bottomEnd = 16.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = cornflowerBlue,
                ),
                contentPadding = PaddingValues(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add),
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
        ) {
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