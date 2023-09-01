package id.lunaratechno.features.home.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.lunaratechno.features.home.viewmodel.HomeViewModel
import id.lunaratechno.core.utils.numberFormat
import id.lunaratechno.qrcodemodular.ui.theme.h5

@Composable
fun HeaderComponen(vm: HomeViewModel) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "Selamat Siang, Rizky Haris Risaldi", style = h5)
        if (vm.saldoState.value>0 )Text(text = "Saldo anda saat ini : ")
        if (vm.saldoState.value>0 )Text(text = "Rp. ${numberFormat(vm.saldoState.value)}")
    }
}