package com.example.mycharacterlist.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mycharacterlist.ui.navigation.Screen

data class BottomBarItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)