package kitefoundation.tech.lesson1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val service: TodoInterface
): ViewModel(){

    private val _todoResponseLiveData: MutableLiveData<List<TodoModel>> = MutableLiveData()
    val todoResponse get() = _todoResponseLiveData

    init {
        getTodos()
    }

    fun getTodos() = viewModelScope.launch {
        val response = service.getAllTodos()
        if (response.isSuccessful) {
            _todoResponseLiveData.value = response.body()
        }
    }
}