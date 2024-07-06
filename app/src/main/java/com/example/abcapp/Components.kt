package com.example.abcapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
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
import com.example.abcapp.components.SpacerWidth
import com.example.abcapp.data.ShoeData
import com.example.abcapp.data.shoeList
import com.example.abcapp.ui.theme.black
import com.example.abcapp.ui.theme.cornflowerBlue
import com.example.abcapp.ui.theme.lightGrey


var mapList = mapOf(
    R.drawable.nike to "Nike",
    R.drawable.adidas to "Adidas",
    R.drawable.puma to "Puma",
    R.drawable.converse to "Converse",
    R.drawable.under_armour to "Under Armour",
)

data class Shoes(
    val id: Int, val name: String, @DrawableRes val icon: Int
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
fun NewHeaderDesign(
    modifier: Modifier = Modifier,
    title: @Composable (BoxScope.(modifier: Modifier) -> Unit)? = null,
    leadingIcon: (@Composable BoxScope.() -> Unit)? = null,
    trailingIcon: (@Composable BoxScope.(modifier: Modifier) -> Unit)? = null,
) {

    Box(modifier = modifier.fillMaxWidth()) {
        leadingIcon?.invoke(this)
        title?.invoke(this, Modifier)
        trailingIcon?.invoke(this, Modifier)
    }
}

@Composable
fun HeaderDesign(
    modifier: Modifier = Modifier,
    title: @Composable (ColumnScope.() -> Unit)? = null,
    leadingIcon: @Composable (RowScope.() -> Unit)? = null,
    trailingIcon: @Composable (RowScope.() -> Unit)? = null,
) {

    Box(modifier = modifier.fillMaxWidth()) {
        // leading icon
        Row(modifier = Modifier.align(Alignment.CenterStart)) {
            leadingIcon?.invoke(this)
        }
        // title
        Column(modifier = Modifier.align(Alignment.Center)) {
            title?.invoke(this)
        }
        // trailing icon
        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            trailingIcon?.invoke(this)
        }
    }

    Column {
        Row {
            Column {
                Row {
                    Column {
                        Box {}
                    }
                }
            }
        }
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
        modifier = modifier.drawBehind {
            if (background) {
                drawCircle(
                    color = Color.White
                )
            }
        }, onClick = onClick
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = contentDescription,
            tint = tint
        )
    }
}

@Composable
fun Circle(modifier: Modifier = Modifier, color: Color = Color.Red, size: Int = 8) {
    Spacer(
        modifier = modifier
            .background(color, CircleShape)
            .size(size.dp)
    )

//    Box(
//        modifier = Modifier
//            .background(Color.Black, CircleShape)
//            .size(20.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Spacer(
//            modifier = Modifier
//                .background(Color.Red, CircleShape)
//                .size(16.dp)
//        )
//    }
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
        modifier = modifier, shape = CircleShape, colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) cornflowerBlue else Color.White,
        ), onClick = { onClick(index) }, contentPadding = if (isSelected) PaddingValues(
            top = 10.dp, bottom = 10.dp, start = 10.dp, end = 30.dp
        ) else PaddingValues(10.dp)
    ) {
        if (isSelected) {
            CustomIcon(icon = data.icon,
                contentDescription = data.name,
                onClick = { onClick(index) })
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
        modifier = modifier.padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f), text = header, style = TextStyle(
                fontSize = 16.sp, fontWeight = FontWeight.SemiBold
            )
        )
        TextButton(
            onClick = onClick, colors = ButtonDefaults.textButtonColors(
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
    isFavorite: Boolean = false,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(180.dp, 280.dp)
            .background(
                color = Color.White, shape = RoundedCornerShape(16.dp)
            )
            .padding(start = 8.dp)
    ) {
        Column(modifier = modifier.padding(bottom = 8.dp)) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit,
                painter = painterResource(id = shoeData.image[0]),
                contentDescription = shoeData.name
            )
            Spacer(modifier = Modifier.height(8.dp))
            NamePriceAndDes(shoeData = shoeData)
        }
        // Add to cart button
        if (!isFavorite) {
            Button(
                modifier = Modifier.align(Alignment.BottomEnd),
                onClick = onClick,
                shape = RoundedCornerShape(
                    topStart = 30.dp, bottomEnd = 16.dp
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
        } else {
            CustomIcon(
                icon = R.drawable.heart,
                contentDescription = "Heart",
                background = true,
                onClick = onClick
            )
            // Color list

            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                shoeData.colorList.forEach {
                    Circle(
                        color = it, size = 16
                    )
                }
            }
        }
    }

}

@Composable
fun ShoeItem1(
    modifier: Modifier = Modifier,
    shoeData: ShoeData,
    isFavorite: Boolean = false,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier.background(
            color = Color.White, shape = RoundedCornerShape(16.dp)
        )
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = shoeData.image[0]),
                    contentDescription = shoeData.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(116.dp)
                )
            }
            NamePriceAndDes(shoeData = shoeData, isPriceShow = false)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(0.5f),
                    text = "$${shoeData.price}",
                    style = TextStyle(
                        fontSize = 18.sp, fontWeight = FontWeight.SemiBold
                    )
                )
                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .weight(0.5f),
                    horizontalArrangement = Arrangement.End,
                ) {
                    shoeData.colorList.forEach {
                        Circle(
                            color = it, size = 16, modifier = Modifier.padding(end = 5.dp)
                        )
                    }
                }
            }
        }
        CustomIcon(
            icon = R.drawable.heart,
            contentDescription = "Heart",
            background = true,
            onClick = onClick,
        )
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
    modifier: Modifier = Modifier, shoeData: ShoeData
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White, shape = RoundedCornerShape(16.dp)
            )
            .padding(start = 24.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        NamePriceAndDes(shoeData = shoeData)
        Image(
            modifier = Modifier
                .weight(1f)
                .size(130.dp),
            contentScale = ContentScale.Fit,
            painter = painterResource(id = shoeData.image[0]),
            contentDescription = shoeData.name
        )
    }
}

@Composable
fun NamePriceAndDes(
    modifier: Modifier = Modifier, shoeData: ShoeData, nameStyle: TextStyle = TextStyle(
        fontSize = 18.sp, fontWeight = FontWeight.SemiBold
    ), priceStyle: TextStyle = TextStyle(
        fontSize = 18.sp, fontWeight = FontWeight.SemiBold
    ), isPriceShow: Boolean = true
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = shoeData.description, color = cornflowerBlue, style = TextStyle(
                fontSize = 14.sp
            )
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp), text = shoeData.name, style = nameStyle
        )
        if (isPriceShow) Text(
            modifier = Modifier.padding(top = 4.dp), text = "$${shoeData.price}", style = priceStyle
        )
    }
}

@Composable
fun ShoeSizeButton(
    modifier: Modifier = Modifier, isSelected: Boolean = false, shoeSize: Int, onClick: () -> Unit
) {
    IconButton(
        modifier = modifier.background(
            color = if (isSelected) cornflowerBlue else lightGrey,
            shape = CircleShape
        ), onClick = onClick
    ) {
        Text(text = "$shoeSize")
    }
}

@Composable
fun ShoeSizeType(
    modifier: Modifier = Modifier, isSelected: Boolean, text: String, onClick: () -> Unit
) {
    Text(modifier = modifier
        .clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }) { onClick() }
        .padding(start = 12.dp), text = text, style = TextStyle(
        color = if (isSelected) black else Color.Gray
    ))
}

@Composable
fun BottomDesignAddToCart(
    modifier: Modifier = Modifier,
    price: String,
    priceStyle: TextStyle = TextStyle(),
    onClick: () -> Unit
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Price", color = Color.Gray
            )
            Text(
                text = "$$price", style = priceStyle
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = cornflowerBlue
            ),
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 32.dp),
            onClick = onClick
        ) {
            Text(
                text = "Add To Card", style = TextStyle(
                    fontSize = 18.sp
                )
            )
        }
    }
}


