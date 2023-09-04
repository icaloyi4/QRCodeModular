package id.lunaratechno.features.transaction.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.lunaratechno.core.database.entity.TransactionEntity
import id.lunaratechno.core.utils.numberFormat
import id.lunaratechno.qrcodemodular.ui.theme.body1

@Preview
@Composable
fun ItemTransaction(transactionEntity: TransactionEntity) {
    Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
        Text(text = "${transactionEntity.idTrans}", style = body1)
        Row {
            Text(text = "${transactionEntity.merchant}", style = body1, modifier = Modifier.wrapContentWidth())
            Text(text = "Rp. ${numberFormat((transactionEntity.value?:0.0))}", style = body1, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())
        }

    }
}