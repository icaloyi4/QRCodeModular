package id.lunaratechno.core.network

data class BaseResponse<T>(
    var code : Int?,
    var message : String?,
    var data : T
)