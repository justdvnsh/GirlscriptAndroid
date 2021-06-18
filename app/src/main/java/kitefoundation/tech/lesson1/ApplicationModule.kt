package kitefoundation.tech.lesson1

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

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

    @Provides
    fun providesTodoDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        TodoDatabase::class.java,
        "todosDatabase"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTodoDaoInterface(db: TodoDatabase) = db.getTodosDao()

}