
package id.lunaratechno.features.transaction.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import id.lunaratechno.core.component.TopAppBarShared
import id.lunaratechno.features.transaction.view.component.ItemTransaction
import id.lunaratechno.features.transaction.viewmodel.TransactionViewModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TransactionScreen(navController: NavController?=null) {
    val mv : TransactionViewModel = koinViewModel()
        Scaffold(topBar = {
            TopAppBarShared(title = "Transaction History", backCallback = { navController?.popBackStack() }, bgColor = null, backIcon = true)

        }) {
            if(mv.loadingState.value) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn{
                    items(mv.listTransactionState.value) {
                        ItemTransaction(it)
                        Divider()
                    }
                }
            }

        }


}

@Preview
@Composable
fun TransactionScreenPreview(){
    TransactionScreen()
}
