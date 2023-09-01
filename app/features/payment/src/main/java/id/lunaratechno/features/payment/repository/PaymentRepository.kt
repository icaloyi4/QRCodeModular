package id.lunaratechno.features.payment.repository

import id.lunaratechno.core.database.DatabaseDao
import id.lunaratechno.core.database.PreferenceModel
import id.lunaratechno.core.database.PreferencesManager
import id.lunaratechno.core.database.entity.TransactionEntity
import id.lunaratechno.features.payment.model.TransactionModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PaymentRepository(val preff: PreferencesManager, val database: DatabaseDao) {
    fun payQR(data: TransactionModel) = flow<Boolean> {
        var isSucces = false
        try {
            database.addTransaction(TransactionEntity(data.bank, data.idTrans, data.merchant, data.value))
            var saldo = preff.getData(PreferenceModel.SALDO_KEY, defaultValue = "")
            if (saldo.isEmpty()){
                preff.saveData(PreferenceModel.SALDO_KEY, (1000000000-(data.value?:0.0)).toString())
            } else {
                preff.saveData(PreferenceModel.SALDO_KEY, (saldo.toDouble()-(data.value?:0.0)).toString())
            }
            isSucces = true
        } catch (e : Exception){

        }

        emit(isSucces)
    }.flowOn(Dispatchers.IO)
}