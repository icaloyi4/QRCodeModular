package id.lunaratechno.features.promo.model

import com.google.gson.Gson
import id.lunaratechno.core.base.JsonNavType
import id.lunaratechno.core.network.response.BankPromoResponse

class BankPromoTypeArgs : JsonNavType<BankPromoResponse>() {
    override fun fromJsonParse(value: String): BankPromoResponse = Gson().fromJson(value, BankPromoResponse::class.java)
    override fun BankPromoResponse.getJsonParse(): String = Gson().toJson(this)


}