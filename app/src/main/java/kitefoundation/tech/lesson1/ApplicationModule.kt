package kitefoundation.tech.lesson1

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    fun providesRetrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    @Provides
    fun providesTodoInterface(
        retrofit: Retrofit
    ): TodoInterface = retrofit.create(TodoInterface::class.java)

}