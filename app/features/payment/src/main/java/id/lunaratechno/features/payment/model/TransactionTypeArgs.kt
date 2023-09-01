package id.lunaratechno.features.payment.model

import com.google.gson.Gson
import id.lunaratechno.core.base.JsonNavType

class TransactionTypeArgs : JsonNavType<TransactionModel>() {
    override fun fromJsonParse(value: String): TransactionModel = Gson().fromJson(value, TransactionModel::class.java)
    override fun TransactionModel.getJsonParse(): String =Gson().toJson(this)


}