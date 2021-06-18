package kitefoundation.tech.lesson1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TodoModel::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDatabase: RoomDatabase(){

    abstract fun getTodosDao(): TodoDao
}