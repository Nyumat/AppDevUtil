package com.example.playgroundappdev.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlinx.*

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    coroutineScope.launch {
        try {
            val response = CatApi.retrofitService.getDevices().await()
            println("getDevices success: $response")

/*            // convert response JSONArray to
            val data = JSONObject(response).getJSONArray("data")
            // loop through data
            val itemList = mutableListOf<BirthdayModel>()
            for (i in 0 until data.length()) {
                try {
                    val item = data.getJSONObject(i)
                    val id = item.getString("id")
                    val name = item.getString("name")
                    val date = Date(item.getString("date"))
                    val listItem = BirthdayModel(id, name, date)
                    itemList.add(listItem)
*/
            } catch (e: Exception) {
                Log.e(TAG, "parseBirthdays error: $e")
            }
        }
/*
            CurrentStatesModel.birthdays = itemList

            val birthdayList = CurrentStatesModel.birthdays
            // sort by date whoever's date is closest to today, and then alphabetically by name
            birthdayList.sortWith(Comparator { o1, o2 ->
                return@Comparator compareBirthdays(o1.date, o2.date, o1.name, o2.name)
            })
            CurrentStatesModel.birthdays = birthdayList

            // populate list
            val list = mutableListOf<ListItem>()
            birthdayList.forEach {
                val item = ListItem(it.name, it.date)
                list.add(item)
            }
            // sort by date whoever's date is closest to today, and then alphabetically by name
            list.sortWith(Comparator { o1, o2 ->
                return@Comparator compareBirthdays(o1.date, o2.date, o1.name, o2.name)
            })
            birthdays.postValue(list)
        } catch (e: Exception) {
            e.printStackTrace()
            */
            Log.e(TAG, "getDevices fail: ${e.localizedMessage}")

            showError.postValue(true)
        }

        loading.postValue(false)
    }
}