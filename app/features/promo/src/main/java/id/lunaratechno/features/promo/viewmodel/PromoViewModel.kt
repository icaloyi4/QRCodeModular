package id.lunaratechno.features.promo.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.lunaratechno.core.network.response.BankPromoResponse
import id.lunaratechno.features.promo.repository.PromoRepository
import kotlinx.coroutines.launch

class PromoViewModel(val repository: PromoRepository, val ctx: Context) : ViewModel() {

    private val _listPromo = mutableStateOf<List<BankPromoResponse>>(arrayListOf())

    var listPromoState : State<List<BankPromoResponse>> = _listPromo

    private val _laodingState = mutableStateOf<Boolean>(false)
    val loadingState : State<Boolean>  = _laodingState

    init {
        getPromo()
    }

    private fun getPromo() {
        viewModelScope.launch {
            _laodingState.value = true
            repository.getPromo().collect() {
                if (it.code == 200) {
                    _listPromo.value = it.data
                } else {
                    Toast.makeText(ctx, "[${it.code}] "+it.message, Toast.LENGTH_LONG).show()
                }

            }
            _laodingState.value = false
        }
    }
}