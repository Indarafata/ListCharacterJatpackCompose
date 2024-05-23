package com.example.mycharacterlist.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mycharacterlist.model.CharacterData
import com.example.mycharacterlist.ui.theme.MyCharacterListTheme

@Composable
fun DetailCharacter(
    modifier: Modifier = Modifier,
    listId: Int,
    navigateBack: () -> Unit,
) {
    val characters = CharacterData.characters
    val character = characters.filter { it.id == listId }.first()


    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ){
            AsyncImage(
                model = character.photoUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(150.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = character.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 25.dp)
            )
            Text(
                text = character.description,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterListItemPreview() {
    MyCharacterListTheme {
        DetailCharacter(
            listId = 10,
            navigateBack = {
            },
        )
    }
}