package com.example.topbar

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.topbar.ui.theme.GreenJC

@Preview(showSystemUi = true, showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnTopAppBar() {

    val contxt = LocalContext.current.applicationContext

    TopAppBar(title = {
        Text(text = "WhatsApp")
    },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(contxt, "WhatsApp Icon", Toast.LENGTH_SHORT).show()
            }) {
                Icon(painter = painterResource(R.drawable.whatsappicon), contentDescription = "Whatsapp Icon")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = GreenJC,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = {
                Toast.makeText(contxt, "Profile", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Person")
            }

            IconButton(onClick = {
                Toast.makeText(contxt, "Search", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }

            IconButton(onClick = {
                Toast.makeText(contxt, "Menu", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu")
            }
        }
    )
}