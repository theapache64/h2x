package com.theapache64.h2x.di.modules
import com.theapache64.h2x.ui.activities.payment.PaymentActivity

import com.theapache64.h2x.ui.activities.login.LogInActivity
import com.theapache64.h2x.ui.activities.form.FormActivity
import com.theapache64.h2x.ui.activities.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * To hold activities to support AndroidInjection call from dagger.
 */
@Module
abstract class ActivitiesBuilderModule {

    
@ContributesAndroidInjector
abstract fun getSplashActivity(): SplashActivity


    
@ContributesAndroidInjector
abstract fun getLogInActivity(): LogInActivity


    @ContributesAndroidInjector
    abstract fun getFormActivity(): FormActivity
@ContributesAndroidInjector
abstract fun getPaymentActivity(): PaymentActivity

}