package id.lunaratechno.features.portofolio.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.LineChartData
import id.lunaratechno.qrcodemodular.ui.theme.h5

@Composable
fun LineChartComponent(lineChartData: LineChartData) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = "Line Chart", style = h5)
        LineChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            lineChartData = lineChartData
        )
    }
}

