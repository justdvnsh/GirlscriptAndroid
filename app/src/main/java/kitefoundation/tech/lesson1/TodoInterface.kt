package kitefoundation.tech.lesson1

import retrofit2.Response
import retrofit2.http.GET

interface TodoInterface {

    @GET("/todos")
    suspend fun getAllTodos(): Response<List<TodoModel>>
}