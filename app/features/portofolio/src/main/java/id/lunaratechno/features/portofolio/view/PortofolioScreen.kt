package id.lunaratechno.features.portofolio.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import id.lunaratechno.features.portofolio.view.component.DonutChartComponent
import id.lunaratechno.features.portofolio.view.component.LineChartComponent
import id.lunaratechno.features.portofolio.viewmodel.PortofolioViewModel
import id.lunaratechno.core.component.TopAppBarShared
import org.koin.androidx.compose.koinViewModel


@ExperimentalLayoutApi
@ExperimentalMaterialApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PortofolioScreen(navController: NavHostController?) {
    val mv : PortofolioViewModel = koinViewModel()
    Scaffold(topBar = {
        TopAppBarShared(title = "My Portofolio", backCallback = { navController?.popBackStack() }, bgColor = null, backIcon = true)
    }) {


        LazyColumn(){
            item {
                mv.donutDataState.value?.let {
                    if(it.slices.isNotEmpty()){
                        DonutChartComponent(donutChartData = it, mv)
                    }

                }
            }
            item {
                mv.lineDataState.value?.let {
                    if (it.linePlotData.lines.isNotEmpty()){
                        LineChartComponent(lineChartData = it)
                    }

                }
            }
        }


    }
}