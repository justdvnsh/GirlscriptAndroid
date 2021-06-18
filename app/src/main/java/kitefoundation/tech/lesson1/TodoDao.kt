package kitefoundation.tech.lesson1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(todo: TodoModel): Long

    @Query("SELECT * FROM todos")
    fun getAllTodos(): LiveData<List<TodoModel>>
}