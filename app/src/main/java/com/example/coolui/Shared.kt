package com.example.coolui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coolui.ui.theme.BarColour
import com.example.coolui.ui.theme.contactsGray
import com.example.coolui.ui.theme.contactsGreen

@Composable
fun BottomContactsAppBar() {
    BottomNavigation(backgroundColor = BarColour, modifier = Modifier
        .background(
            BarColour
        )
        .height(68.dp)) {
        var selected by remember {mutableStateOf("Chats")}
        Row() {
            BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, icon = {
                BadgedBox(badge = {Badge(backgroundColor = contactsGreen) {Text("3")}}) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.chat_final
                        ),
                        contentDescription = "Chats",
                        modifier = Modifier
                            .size(34.dp)
                            .padding(bottom = 8.dp)
                            .drawBehind {
                                drawRoundRect(
                                    Color(0x5FFFFFFF),
                                    alpha = 0.5f,
                                    cornerRadius = CornerRadius(20.dp.toPx(), 20.dp.toPx()),
                                    size = Size(200f, 106f),
                                    topLeft = Offset(y = -6f, x = -38f)
                                )
                            }, tint = Color.White,

                        )
                }

            }, label = { Text(text = "Chats", style = TextStyle(fontWeight = FontWeight.Bold), color = Color.White)})
            BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, icon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Call", tint = contactsGray,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }, label = {GreyText("Update",  textStyle = TextStyle(fontWeight = FontWeight.Bold))})
            BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, icon = {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Edit", tint = contactsGray,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }, label = {GreyText("Calls",  textStyle = TextStyle(fontWeight = FontWeight.Bold))})
            BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, icon = {
                                                                                 Icon(
                                                                                     imageVector = Icons.Default.Person,
                                                                                     contentDescription = "Community", tint = contactsGray,
                                                                                     modifier = Modifier.padding(bottom = 8.dp)
                                                                                 )
            }, label = {GreyText("Community",  textStyle = TextStyle(fontWeight = FontWeight.Bold))}, )
        }

    }
}

@Composable
fun TopContactsAppBar() {

    TopAppBar(title = {GreyText("WhatsApp", textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))},actions= {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Icon(painterResource(id = R.drawable.baseline_camera_alt_24), contentDescription = "Camera", tint = contactsGray)
            Icon(Icons.Outlined.Search, contentDescription = "Search", tint = contactsGray)
            Icon(Icons.Default.MoreVert, contentDescription = "Menu", tint = contactsGray)
        }
    }, backgroundColor = BarColour)
}

@Composable
fun GreyText(text: String, modifier: Modifier = Modifier,  textStyle: TextStyle = TextStyle(), notified: Boolean = false) {
    Text(text = text, modifier = Modifier, style = textStyle + TextStyle(color = if(!notified) contactsGray else contactsGreen ))
}