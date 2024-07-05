package com.example.abcapp

import android.icu.text.NumberFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.ui.theme.cornflowerBlue
import com.example.abcapp.ui.theme.lightGrey
import com.example.abcapp.ui.theme.lightGreyForBackGround
import com.example.abcapp.ui.theme.unselectedColor
import com.example.abcapp.ui.theme.unselectedTextColor
import java.util.Locale

val genderList = listOf("Men", "Women", "Kids")
val sizeTypes = listOf("UK 4.4", "US 5.5", "UK 6.5", "EU 11.5", "US 12.5", "UK 13.5")

@Composable
private fun BottomSheetForHomePage(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFFFFFF))
    ) {
        header()
        content()
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomSheetView() {
    ReadyBottomSheetForHomePage() {

    }

}

@Composable
fun ReadyBottomSheetForHomePage(
    modifier: Modifier = Modifier,
    onClick: () -> Unit) {
    var selectedGender by remember { mutableIntStateOf(0) }
    var selectedSize by remember { mutableIntStateOf(1) }
    var sliderValue by remember { mutableFloatStateOf(0f) }
    BottomSheetForHomePage(
        header = {
            HeaderDesign(
                modifier = Modifier.padding(16.dp),
                title = {
                    Text(
                        text = "Filters",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                },
                trailingIcon = {
                    TextButton(
                        onClick = {
                            //TODO RESET action will be here
                            selectedGender = 0
                            selectedSize = 1
                            sliderValue = 0f
                        },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Text(text = "RESET")
                    }
                }
            )
        },
        content = {
            // Gender Selection
            Text( text = "Gender",
                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            // Gender Selection Buttons
            ButtonListRow(
                modifier = Modifier.fillMaxWidth(),
                buttonList = genderList,
                isSelected = selectedGender,
                onClick = {
                    selectedGender = it
                }
            )
            // Size Selection
            Text( text = "Size",
                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            // size selection buttons
            ButtonListRow(
                modifier = Modifier.fillMaxWidth(),
                buttonList = sizeTypes,
                isSelected = selectedSize,
                onClick = {
                    selectedSize = it
                }
            )
            // Price Range
            Text( text = "Price",
                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            // price range slider
            Slider(
                value = sliderValue ,
                onValueChange = {sliderValue = it},
                modifier = Modifier.padding(horizontal = 16.dp),
                valueRange = 0f..2000f,
                colors = SliderDefaults.colors(
                    thumbColor = cornflowerBlue,
                    activeTrackColor = cornflowerBlue,
                    inactiveTrackColor = unselectedColor
                )
            )
            // Price Range
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "$${sliderValue.toInt()}",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    text = "$${sliderValue.toInt()}",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
            // filter apply button
            CustomButton(
                modifier = modifier.padding(16.dp),
                onClick = onClick,
                buttonColor = cornflowerBlue,
                contentColor = Color.White,
                ) {
                Text(text = "Apply")
            }
        }
    )
}

@Composable
fun ButtonListRow(
    modifier: Modifier = Modifier,
    buttonList: List<String>,
    isSelected: Int,
    onClick: (Int) -> Unit
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        item {}
        itemsIndexed(buttonList) {
                index, item ->
            Button(
                onClick = { onClick(index) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected == index) cornflowerBlue else unselectedColor,
                    contentColor = if (isSelected == index) Color.White else unselectedTextColor
                )
            ) {
                Text(text = item)
            }

        }
    }
}
