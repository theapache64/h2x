package com.theapache64.h2x

import android.app.Activity
import android.app.Application
import com.theapache64.h2x.data.repositories.UserPrefRepository
import com.theapache64.h2x.di.components.DaggerAppComponent
import com.theapache64.openupi.OpenUPI
import com.theapache64.twinkill.TwinKill
import com.theapache64.twinkill.di.modules.ContextModule
import com.theapache64.twinkill.googlefonts.GoogleFonts
import com.theapache64.twinkill.network.di.modules.BaseNetworkModule
import com.theapache64.twinkill.network.utils.retrofit.interceptors.CurlInterceptor
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>


    var userPrefRepository: UserPrefRepository? = null
        @Inject set


    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()

        // Dagger
        DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .baseNetworkModule(BaseNetworkModule(BASE_URL))
            .build()
            .inject(this)

        // TwinKill
        TwinKill.init(
            TwinKill
                .builder()
                .setNeedDeepCheckOnNetworkResponse(false)
                .addOkHttpInterceptor(CurlInterceptor())
                .setDefaultFont(GoogleFonts.GoogleSansRegular)
                .build()
        )

        OpenUPI.init(
            "8301893919@ybl",
            "Shifar"
        )

    }


    companion object {
        private const val BASE_URL = "http://api.sheety.co/"
    }
}
