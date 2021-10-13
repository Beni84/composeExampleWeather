package com.gigigo.composeexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gigigo.composeexample.domain.SnackMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class AuthState(
  val message: SnackMessage? = null
)

@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModel() {

  private val _state: MutableLiveData<AuthState> by lazy {
    MutableLiveData<AuthState>().apply { value = AuthState() }
  }
  val state: LiveData<AuthState> by lazy { _state }

  fun onClickPhone() {
    _state.postValue(
      state.value?.copy(message = SnackMessage("Click on phone icon"))
    )
  }

  fun onClose() {
    _state.postValue(
      state.value?.copy(message = null)
    )
  }
}