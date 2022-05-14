package com.example.taxcalculatorandroid.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taxcalculatorandroid.model.Region
import com.example.taxcalculatorandroid.repository.RegionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegionViewModel @Inject constructor(private val repository: RegionRepository) : ViewModel(){
    private val _regionList = MutableStateFlow<List<Region>>(emptyList())
    val regionList = _regionList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllRegions().distinctUntilChanged()
                .collect {listOfRegions ->
                    if (listOfRegions.isNullOrEmpty()){
                        Log.d("Get List", ":The list is empty ")
                    } else{
                        _regionList.value = listOfRegions
                    }
                }
        }
    }

    fun addRegion(region : Region) = viewModelScope.launch { repository.addRegion(region) }
    fun updateRegion(region : Region) = viewModelScope.launch { repository.updateRegion(region) }
    fun removeRegion(region : Region) = viewModelScope.launch { repository.deleteRegion(region) }

}