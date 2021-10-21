package com.scorpiona.composerecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.scorpiona.composerecyclerview.compose.TvShowListItem
import com.scorpiona.composerecyclerview.data.TvShowList
import com.scorpiona.composerecyclerview.model.TvShow
import com.scorpiona.composerecyclerview.ui.theme.ComposeRecyclerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayTvShows{
                startActivity(InfoActivity.intent(this, it))
            }
        }
    }
}

@Composable
private fun DisplayTvShows(selectedItem: (TvShow)->(Unit)){
    val tvShows = remember { TvShowList.tvShows }
    LazyColumn(
        modifier = Modifier.background(color = Color.Black),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 7.5.dp)
    ){
        items(
            items = tvShows,
            itemContent = {
                TvShowListItem(tvShow = it, selectedItem)
            }
        )
    }
}