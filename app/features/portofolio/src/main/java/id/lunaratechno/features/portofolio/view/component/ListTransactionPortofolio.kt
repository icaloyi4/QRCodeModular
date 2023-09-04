package id.lunaratechno.features.portofolio.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.lunaratechno.features.portofolio.model.TransferData
import id.lunaratechno.core.utils.numberFormat
import id.lunaratechno.qrcodemodular.ui.theme.h5

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ListTransactionPortofolio(transferData: List<TransferData>) {
    Column() {
        Text(text = "Transfer List", style = h5)
        FlowColumn() {
            transferData.forEach(){ data ->
                Text(text = "${data.trxDate} Rp. ${numberFormat(data.nominal?.toDouble()?:0.0)}", modifier = Modifier.padding(10.dp))
            }

        }
    }
}