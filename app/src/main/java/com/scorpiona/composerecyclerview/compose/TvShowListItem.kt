package com.scorpiona.composerecyclerview.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.scorpiona.composerecyclerview.compose.TvShowImage
import com.scorpiona.composerecyclerview.model.TvShow

@Composable
fun TvShowListItem(tvShow: TvShow, selectedItem: (TvShow)->(Unit)){
    Card(
        modifier = Modifier
            .padding(12.dp)
            .background(color = Color.DarkGray)
            .fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(15.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .clickable { selectedItem(tvShow) }
                .background(color = Color.DarkGray),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TvShowImage(tvShow = tvShow)
            Column {
                Text(text = tvShow.name, style = MaterialTheme.typography.h5, color = Color.White)
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = tvShow.overview,
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis)
                Spacer(modifier = Modifier.height(7.dp))
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = tvShow.year.toString(), style = MaterialTheme.typography.h5, color = Color.White)
                    Text(text = tvShow.rating.toString(), style = MaterialTheme.typography.h5, color = Color.White)
                }
            }
        }
    }
}