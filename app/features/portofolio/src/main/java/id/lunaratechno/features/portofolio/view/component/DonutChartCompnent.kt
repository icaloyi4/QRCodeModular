package id.lunaratechno.features.portofolio.view.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import id.lunaratechno.features.portofolio.viewmodel.PortofolioViewModel
import co.yml.charts.ui.piechart.charts.DonutPieChart
import co.yml.charts.ui.piechart.models.PieChartData
import id.lunaratechno.core.other.pieChartConfig
import id.lunaratechno.qrcodemodular.ui.theme.h5

@ExperimentalLayoutApi
@ExperimentalMaterialApi
@Composable
fun DonutChartComponent(donutChartData: PieChartData, mv: PortofolioViewModel, ) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = "Donut Chart", style = h5)
        FlowRow {
            repeat(donutChartData.slices.size) {index->
                Box(modifier = Modifier.padding(10.dp)) {
                    Card(backgroundColor = donutChartData.slices[index].color) {
                        Text(text = donutChartData.slices[index].label, modifier = Modifier.padding(10.dp), color = Color.White)
                    }
                }
                }


        }
        DonutPieChart(modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
            pieChartData = donutChartData,
            pieChartConfig = pieChartConfig,
            onSliceClick = {
                mv.selectedTransferData(it)
            })
        mv.selectedTransferState.value?.let {
            ListTransactionPortofolio(it)
        }
        Divider()

    }
}