package kitefoundation.tech.lesson1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class SearchViewModel(
    private val repo: SearchRepository
): ViewModel() {

    private val _searchString: MutableLiveData<String> = MutableLiveData()
    val searchString: LiveData<String> get() = _searchString


    fun getSearchString(text: String) = viewModelScope.launch {
        _searchString.value = text
    }
}