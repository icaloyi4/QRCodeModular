package id.lunaratechno.qrcodemodular.routes

import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import id.lunaratechno.features.notification.view.NotificationScreen
import id.lunaratechno.features.home.view.HomeScreen
import id.lunaratechno.features.notification.view.ResultScreen
import id.lunaratechno.features.payment.view.PaymentScreen
import id.lunaratechno.features.portofolio.view.PortofolioScreen
import id.lunaratechno.features.promo.view.PromoScreen
import id.lunaratechno.features.transaction.view.TransactionScreen

@ExperimentalMaterialApi
@ExperimentalGetImage
@ExperimentalLayoutApi
@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = RoutesModel.home) {
        composable(RoutesModel.home) {
            HomeScreen(navController)
        }
        composable(RoutesModel.promo) {
            PromoScreen(navController)
        }
        composable(RoutesModel.payment) {
            PaymentScreen(navController)
        }
        composable(RoutesModel.transaction) {
            TransactionScreen(navController)
        }
        composable(RoutesModel.portofolio) {
            PortofolioScreen(navController)
        }
        composable(RoutesModel.notification) {
            NotificationScreen(navController)
        }
////        composable(RoutesModel.result+"?title={title}&transactionCode={transaction_code}", deepLinks = listOf(
////            navDeepLink {
////                uriPattern = "sample.id://transfer/result?title={title}&transactionCode={transaction_code}"
////            }
////        )) {
////            val title = it.arguments?.getString("title")
////            val transactionCode = it.arguments?.getString("transaction_code")
////            ResultScreen(navController,title?:"Failed",transactionCode?:"")
////        }
//
        navigation(
            startDestination = RoutesModel.result+"?title={title}&transactionCode={transaction_code}",
            route = "nested_graph_route"
        ) {
            composable(
                route = RoutesModel.result+"?title={title}&transactionCode={transaction_code}",
                deepLinks = listOf(
                    navDeepLink { uriPattern = "sample.id://transfer/result?title={title}&transactionCode={transaction_code}" } // Note that this pattern has no relation to the route itself
                )
            ) {
                val title = it.arguments?.getString("title")
                val transactionCode = it.arguments?.getString("transaction_code")
                ResultScreen(navController,title?:"Failed",transactionCode?:"")
            }
        }
//        composable(route = "${RoutesModel.screeninfo}/{transaction}",
//            arguments = listOf(
//                navArgument("transaction") {
//                    type = TransactionTypeArgs()
//                }
//            )) {
//            ScreenInfoPayment(
//                navController,data = it.arguments?.getString("transaction")
//                    ?.let { data -> Gson().fromJson(data, TransactionModel::class.java) })
//        }
//        composable(route = "${RoutesModel.promodetail}/{promo}",
//            arguments = listOf(
//                navArgument("promo") {
//                    type = BankPromoTypeArgs()
//                }
//            )) {
//            PromoDetailScreen(
//                navController,data = it.arguments?.getString("promo")
//                    ?.let { data -> Gson().fromJson(data, BankPromoResponse::class.java) })
//        }
    }
}