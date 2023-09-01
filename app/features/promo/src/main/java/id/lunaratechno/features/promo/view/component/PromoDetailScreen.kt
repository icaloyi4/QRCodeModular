package id.lunaratechno.features.promo.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import id.lunaratechno.core.component.CloseBtnRight
import id.lunaratechno.core.network.response.BankPromoResponse
import id.lunaratechno.qrcodemodular.ui.theme.h1

//@Preview
@Composable
fun PromoDetailScreen(navController: NavController?, data : BankPromoResponse?){
    Surface(modifier = Modifier.fillMaxSize()) {

        Column {
            Image(
                painter = rememberAsyncImagePainter("${data?.img?.formats?.medium?.url}", filterQuality = FilterQuality.High),
                contentDescription = null,
                modifier = Modifier
                    .width((data?.img?.formats?.medium?.width?:200).dp),
                contentScale = ContentScale.FillWidth
            )
            Column (modifier = Modifier.padding(10.dp)) {
                Text(text = data?.nama?:"-", style = h1)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Promo Detail")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = data?.desc?:"-")
            }


        }
        CloseBtnRight(onClose = {
            navController?.popBackStack()
        })
    }
}