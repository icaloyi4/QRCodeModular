package id.lunaratechno.features.home.view.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.lunaratechno.core.routes.MenuItem

@Composable
fun MenuItemComponent(icon : Int, title : String, onClick : () -> Unit){
    Card(modifier = Modifier
        .padding(10.dp)
        .clickable { onClick() }) {
        Column(
            modifier = Modifier.padding(10.dp).width(100.dp).height(100.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(painter = painterResource(id = icon), contentDescription = title, modifier = Modifier.size(50.dp))
            Text(text = title, overflow = TextOverflow.Ellipsis, maxLines = 2, textAlign = TextAlign.Center, softWrap = true, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun HomeMenu(navController: NavController){
    val itemsMenu = listOf(
        MenuItem.Transaction,
        MenuItem.Portofolio,
        MenuItem.Notification
    )
    LazyVerticalGrid (columns = GridCells.Adaptive(minSize = 100.dp)
    ) {
        items(itemsMenu){item->
        MenuItemComponent(icon = item.icon!!, title = item.title, onClick = {
            navController.navigate(item.screen_route)
        })
    }
    }
}
