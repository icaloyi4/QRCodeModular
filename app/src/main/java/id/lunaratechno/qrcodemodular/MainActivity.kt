@file:OptIn(
    ExperimentalMaterialApi::class, ExperimentalLayoutApi::class,
    ExperimentalLayoutApi::class, ExperimentalLayoutApi::class
)

package id.lunaratechno.qrcodemodular

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import id.lunaratechno.core.injection.apiModule
import id.lunaratechno.core.injection.dataStoreModule
import id.lunaratechno.core.injection.databaseModule
import id.lunaratechno.core.injection.netModule
import id.lunaratechno.qrcodemodular.injection.repositoryModule
import id.lunaratechno.qrcodemodular.injection.viewModelModule
import id.lunaratechno.qrcodemodular.routes.NavigationGraph
import id.lunaratechno.qrcodemodular.ui.theme.QRCodeModularTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin

@androidx.camera.core.ExperimentalGetImage
class MainActivity : ComponentActivity() {
    override fun onStart() {
        super.onStart()
        startKoin {
            androidContext(this@MainActivity)
            modules(
                listOf(
                    netModule,
                    viewModelModule,
                    apiModule,
                    dataStoreModule,
                    databaseModule,
                    repositoryModule
                )
            )
        }
    }

    override fun onPause() {
        super.onPause()
        stopKoin()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRCodeModularTheme {
                RootScreen()
            }
        }
    }
}

@ExperimentalLayoutApi
@ExperimentalMaterialApi
@Composable
@androidx.camera.core.ExperimentalGetImage
fun  RootScreen() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        NavigationGraph(navController = navController)
    }
}

@androidx.camera.core.ExperimentalGetImage
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QRCodeModularTheme {
        RootScreen()
    }
}