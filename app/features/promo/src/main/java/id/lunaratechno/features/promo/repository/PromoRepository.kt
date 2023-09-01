package id.lunaratechno.features.promo.repository

import android.util.Log
import id.lunaratechno.core.network.ApiClient
import id.lunaratechno.core.network.BaseResponse
import id.lunaratechno.core.network.response.BankPromoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PromoRepository(val apiClient: ApiClient) {

    fun getPromo() = flow<BaseResponse<List<BankPromoResponse>>> {
        try {
            val promoResponse = apiClient.getPromo()
            if (promoResponse.isSuccessful) {
                val baseResponse = BaseResponse<List<BankPromoResponse>>(code = promoResponse.code(), message = "Success", data = promoResponse.body()?: arrayListOf())
                emit(baseResponse)
            } else {

                emit(BaseResponse<List<BankPromoResponse>>(code = promoResponse.code(), message = promoResponse.message(), data = arrayListOf()))
            }
        } catch (e : Exception) {
            Log.e("APIPROMO", e.message.toString())
            emit(BaseResponse<List<BankPromoResponse>>(code = 500, message = e.message, data = arrayListOf()))
        }


    }.flowOn(Dispatchers.IO)

}