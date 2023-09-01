package id.lunaratechno.core.other

import androidx.compose.ui.graphics.Color
import co.yml.charts.ui.piechart.models.PieChartConfig

val pieChartConfig = PieChartConfig(
    isAnimationEnable = true,
    labelColorType = PieChartConfig.LabelColorType.SPECIFIED_COLOR,
    labelVisible = true,
    labelColor = Color.Black,
    labelType = PieChartConfig.LabelType.PERCENTAGE,
    showSliceLabels = true
)