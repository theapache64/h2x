package com.theapache64.h2x.di.modules
import com.theapache64.h2x.ui.activities.payment.PaymentViewModel

import androidx.lifecycle.ViewModel
import com.theapache64.twinkill.di.modules.BaseViewModelModule
import com.theapache64.twinkill.utils.viewmodel.ViewModelKey
import com.theapache64.h2x.ui.activities.login.LogInViewModel
import com.theapache64.h2x.ui.activities.form.FormViewModel
import com.theapache64.h2x.ui.activities.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module(includes = [BaseViewModelModule::class])
abstract class ViewModelModule {


    
@Binds
@IntoMap
@ViewModelKey(SplashViewModel::class)
abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel


    
@Binds
@IntoMap
@ViewModelKey(LogInViewModel::class)
abstract fun bindLogInViewModel(viewModel: LogInViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(FormViewModel::class)
    abstract fun bindFormViewModel(viewModel: FormViewModel): ViewModel
@Binds
@IntoMap
@ViewModelKey(PaymentViewModel::class)
abstract fun bindPaymentViewModel(viewModel: PaymentViewModel): ViewModel

}