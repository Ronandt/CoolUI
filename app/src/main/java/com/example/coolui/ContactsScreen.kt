package com.example.coolui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Badge
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coolui.ui.theme.contactsGray
import com.example.coolui.ui.theme.contactsGreen
import com.example.coolui.ui.theme.doubleTickBlue
import com.example.coolui.ui.theme.listContactsColour
import java.time.format.TextStyle

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ContactsScreen() {

    Scaffold(topBar = { TopContactsAppBar()}, floatingActionButton = { FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = contactsGreen) {
        Icon(painterResource(R.drawable.chat), contentDescription ="Call", tint = Color.White, modifier = Modifier.size(24.dp))
    }}, bottomBar = {
        BottomContactsAppBar()
    }) {
        Box(modifier = Modifier.padding(it)) {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(listContactsColour)) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp), contentPadding = PaddingValues(vertical = 4.dp)) {
                    items(10) {

                        ListItem(icon = { Image(painter = painterResource(R.drawable.small_pfp), contentDescription ="PFP", modifier = Modifier
                            .clip(
                                CircleShape
                            )
                            .size(52.dp))}, text = {
                            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                                Text("Okbuddytrailblazer", color = Color.White, fontWeight = FontWeight.Bold, )

                                GreyText(text = "Yesterday",textStyle = androidx.compose.ui.text.TextStyle(fontSize = 12.sp), notified = it % 3 ==0)
                            } }, singleLineSecondaryText = true, secondaryText = {

                            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                                Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                                    if(it % 3 != 0 && (1..2).random() == 2) {

                                        Icon( painterResource(R.drawable.read), contentDescription = "Read", tint = if((0..1).random() == 0)contactsGray else doubleTickBlue, modifier = Modifier.size(18.dp))



                                    }
                                    GreyText(
                                        text = "Bratty diviner is in need of correction", Modifier.offset(y = 4.dp)
                                    )
                                }

                                if(it % 3 ==0) {
                                    Badge(backgroundColor = contactsGreen, modifier = Modifier
                                        .size(20.dp)
                                        .clip(
                                            CircleShape
                                        )) {
                                        Text(text = "3", fontWeight = FontWeight.SemiBold)
                                    }
                                }

                            }
                           })
                    }

                }
            }
        }
    }
}