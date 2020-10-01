package com.alejandrorios.expose.di

import android.content.Context
import com.alejandrorios.domain.model.Anime
import com.alejandrorios.domain.model.None
import com.alejandrorios.domain.usecase.GetAnimeTrendsUseCase
import com.alejandrorios.expose.AndroidExposeApplication
import com.alejandrorios.expose.utils.CoroutinesContextProvider
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author alejandrorios on 8/15/20
 */
@Singleton
@Component(
    modules = [
        (AndroidSupportInjectionModule::class),
        (AppModule::class),
        (UseCasesModule::class)]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(application: Context): Builder
    }

    fun inject(androidExposeApplication: AndroidExposeApplication)

    fun provideIOCoroutinesContextProvider(): CoroutinesContextProvider

    fun provideGetAnimeTrendsUseCase(): GetAnimeTrendsUseCase
}
