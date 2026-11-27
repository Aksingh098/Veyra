package com.example.veyra.presentation.onBoarding

import androidx.collection.mutableObjectIntMapOf
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.veyra.R
import com.example.veyra.ui.theme.DotInactive
import com.example.veyra.ui.theme.Gold
import com.example.veyra.ui.theme.TextPrimary
import com.example.veyra.ui.theme.TextSecondary

data class OnboardPage(val title: String, val desc: String, val image: Int)

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun OnBoardingScreen() {
    val pagerState = rememberPagerState(pageCount = {
        pages.size
    })
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1C1917),
                        Color(0xFF121110),
                        Color(0xFF090909)
                    )
                )
            )
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("${pagerState.currentPage + 1}/3",
                    style = MaterialTheme.typography.titleLarge,
                    color = TextSecondary,
                    fontWeight = FontWeight.Bold)
                Text(
                    text = "Skip",
                    style = MaterialTheme.typography.titleLarge,
                    color = TextSecondary,
                    fontWeight = FontWeight.Bold
                )

            }

            Spacer(modifier = Modifier.weight(1f))
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(pages[page].image),
                        contentDescription = pages[page].title,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(300.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = pages[page].title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = pages[page].desc,
                        style = MaterialTheme.typography.titleMedium,
                        color = TextSecondary
                    )


                }


            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Gold else DotInactive
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(16.dp)
                    )
                }
            }



        }
    }

}

val pages = listOf(
    OnboardPage("Choose Products", "Browse curated pieces made for you.", R.drawable.choose_products),
    OnboardPage("Make Payment", "Pay securely in a few taps.", R.drawable.payment),
    OnboardPage("Get Your Order", "Delivered to your door, beautifully.", R.drawable.seamless_delivery),
)
