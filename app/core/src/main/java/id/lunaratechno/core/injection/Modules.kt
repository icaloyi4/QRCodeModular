package id.lunaratechno.core.injection

import android.content.Context
import androidx.room.Room
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import id.lunaratechno.core.database.AppDatabase
import id.lunaratechno.core.database.DatabaseDao
import id.lunaratechno.core.database.PreferencesManager
import id.lunaratechno.core.network.ApiClient
import id.lunaratechno.core.network.ApiModel
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val apiModule = module {
    fun provideApi(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    single { provideApi(get()) }
}

val dataStoreModule = module {
    fun providePrefference(ctx: Context): PreferencesManager {
        return PreferencesManager(ctx)
    }
    single { providePrefference(androidContext()) }
}

val netModule = module {
    fun provideCache(application: Context): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    fun provideHttpClient(cache: Cache): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .cache(cache)

        return okHttpClientBuilder.build()
    }

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }


    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiModel.baseURL)
            .addConverterFactory(GsonConverterFactory.create(factory))
//            .addCallAdapterFactory(CoroutineCallAdapterFactory())CoroutineCallAdapterFactoryΩ
            .client(client)
            .build()
    }

    single { provideCache(androidContext()) }
    single { provideHttpClient(get()) }
    single { provideGson() }
    single { provideRetrofit(get(), get()) }

}

val databaseModule = module {

    fun provideDatabase(application: Context): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "eds.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


    fun provideDao(database: AppDatabase): DatabaseDao {
        return database.databaseDao
    }

    single { provideDatabase(androidContext()) }
    single { provideDao(get()) }
}
