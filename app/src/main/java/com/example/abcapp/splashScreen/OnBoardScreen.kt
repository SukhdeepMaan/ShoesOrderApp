package com.example.abcapp.splashScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.abcapp.R
import com.example.abcapp.navigation.ScreenRoute
import com.example.abcapp.ui.theme.cornflowerBlue
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    // scope
    val scope = rememberCoroutineScope()
    // pager state
    val pagerState = rememberPagerState(
    ) { boardingData.size }

    val buttonText =
        if (pagerState.currentPage == boardingData.size - 1)
            stringResource(R.string.get_started) else stringResource(
            R.string.next
        )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(state = pagerState, modifier = Modifier.weight(1f)) { page ->
            BoardingContentDesign(
                modifier = modifier,
                boardingData = boardingData[page]
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PagerIndicator(
                modifier = modifier.padding(start = 24.dp),
                pageCount = pagerState.pageCount,
                currentPage = pagerState.currentPage
            )
            Button(
                onClick = {
                    if (pagerState.currentPage == boardingData.size - 1) {
                        navHostController.navigate(ScreenRoute.LOGIN.route)
                    } else {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
                contentPadding = PaddingValues(32.dp, 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = cornflowerBlue
                )
            ) {
                Text(
                    text = buttonText,
                    style = TextStyle(
                        fontSize = 18.sp
                    )
                )
            }
        }
    }
}
