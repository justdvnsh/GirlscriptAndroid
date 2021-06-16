package kitefoundation.tech.lesson1

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Singleton

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    @Provides
    fun provideSearchRepo(): SearchRepository = SearchRepository()
}