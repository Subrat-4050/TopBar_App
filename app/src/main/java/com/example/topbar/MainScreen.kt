package com.example.topbar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.topbar.pages.HomePage
import com.example.topbar.pages.NotificationPage
import com.example.topbar.pages.SettingsPage
import com.example.topbar.ui.theme.GreenDark

@Preview
@Composable
private fun MainScreen() {
    val navItems = listOf(
        NavItem(label = "Home", icon = Icons.Default.Home, badgeCount = 0),
        NavItem(label = "Notification", icon = Icons.Default.Notifications, badgeCount = 4),
        NavItem(label = "Settings", icon = Icons.Default.Settings, badgeCount = 10)
    )

    var selectedIndex by remember{ mutableIntStateOf(0) }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { LearnTopAppBar() },
        bottomBar = {
            NavigationBar {
                navItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedIndex,
                        onClick = { selectedIndex = index },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount > 0) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    }
                                    if (item.badgeCount > 9) {
                                        Badge {
                                            Text(text = "9+")
                                        }
                                    }
                                }
                            ) {
                                Icon(imageVector = item.icon, contentDescription = item.label)
                            }
                        },
                        label = {
                            Text(text = item.label)
                        },
                        //enabled = index != 1
                        //alwaysShowLabel = index == selectedIndex
                        colors = NavigationBarItemDefaults.colors(GreenDark)

                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
    when(selectedIndex) {
        0 -> HomePage()
        1 -> NotificationPage()
        2 -> SettingsPage()
    }
}