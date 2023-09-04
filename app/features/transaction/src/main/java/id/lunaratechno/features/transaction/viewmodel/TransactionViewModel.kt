package id.lunaratechno.features.transaction.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.lunaratechno.core.database.entity.TransactionEntity
import id.lunaratechno.features.transaction.repository.TransactionRepository
import kotlinx.coroutines.launch

class TransactionViewModel(val repo : TransactionRepository) : ViewModel() {

    private val _listTransaction = mutableStateOf<List<TransactionEntity>>(arrayListOf())

    var listTransactionState : State<List<TransactionEntity>> = _listTransaction

    private val _laodingState = mutableStateOf<Boolean>(false)
    val loadingState : State<Boolean>  = _laodingState

    init {
        getTransactionHistory()
    }
    private fun getTransactionHistory(){
        viewModelScope.launch {
            _laodingState.value = true
            repo.getTransactionHistory().collect() {
                _listTransaction.value = it
            }
            _laodingState.value = false
        }
    }


}