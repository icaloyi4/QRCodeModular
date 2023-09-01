package id.lunaratechno.qrcodemodular.injection

import id.lunaratechno.core.database.DatabaseDao
import id.lunaratechno.core.database.PreferencesManager
import id.lunaratechno.core.network.ApiClient
import id.lunaratechno.features.home.repository.HomeRepository
import id.lunaratechno.features.home.viewmodel.HomeViewModel
import id.lunaratechno.features.payment.repository.PaymentRepository
import id.lunaratechno.features.payment.viewmodel.PaymentViewModel
import id.lunaratechno.features.promo.repository.PromoRepository
import id.lunaratechno.features.promo.viewmodel.PromoViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { PaymentViewModel(get()) }
//    viewModel { TransactionViewModel(get()) }
    viewModel { PromoViewModel(get(), androidContext()) }
//    viewModel { PortofolioViewModel(get()) }
//    viewModel { NotificationViewModel(get()) }
}

val repositoryModule = module {
    fun provideHomeRepository(preff : PreferencesManager): HomeRepository {
        return HomeRepository(preff)
    }

    single { provideHomeRepository(get()) }

    fun providePaymentRepository(preff : PreferencesManager, databaseDao: DatabaseDao): PaymentRepository {
        return PaymentRepository(preff, databaseDao)
    }

    single { providePaymentRepository(get(), get()) }
//
//    fun provideTransactionRepository( databaseDao: DatabaseDao): TransactionRepository {
//        return TransactionRepository(databaseDao)
//    }
//
//    single { provideTransactionRepository( get()) }
//
    fun providePromoRepository(apiClient: ApiClient): PromoRepository {
        return PromoRepository(apiClient)
    }

    single { providePromoRepository( get()) }
//
//    fun providePortofolioRepository(): PortofolioRepository {
//        return PortofolioRepository()
//    }
//
//    single { providePortofolioRepository() }
//
//    fun provideNotificationRepository(): NotificationRepository {
//        return NotificationRepository()
//    }
//
//    single { provideNotificationRepository() }
}