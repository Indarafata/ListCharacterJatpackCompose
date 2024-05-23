package com.example.mycharacterlist.ui.screen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mycharacterlist.model.CharacterData

@Composable
fun ListCharacter(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit,
) {
    Box(modifier = modifier) {
        LazyColumn {
            items(CharacterData.characters, key = { it.id }) { hero ->
                CharacterListItem(
                    id = hero.id,
                    name = hero.name,
                    description = hero.description,
                    photoUrl = hero.photoUrl,
                    navigateToDetail = navigateToDetail,
                )
            }
        }
    }
}

@Composable
fun CharacterListItem(
    id: Int,
    name: String,
    description: String,
    photoUrl: String,
    navigateToDetail: (Int) -> Unit,
) {
    Row(
        modifier = Modifier.padding(8.dp).clickable { navigateToDetail(id) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(text = description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}