package com.revature.retrofitexample.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.revature.retrofitexample.R
import com.revature.retrofitexample.network.Toy
import com.revature.retrofitexample.network.ToyList
import com.revature.retrofitexample.viewmodel.BrowseToysViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun BrowseToys(viewModel:BrowseToysViewModel){

    var lazyState = rememberLazyListState()


    var toyList = viewModel.toyList
    //var toyList by rememberSaveable { mutableStateOf(viewModel.toysListResponse.value) }

    Log.d("BrowseToys", viewModel.toysListResponse.value.toString())

    if (!toyList.results.isEmpty())
    {
        Text(
            toyList.results.get(0).sName,
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center
        )
    }

//    LazyColumn(state = lazyState,
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally){
//
//        if (toyList != null)
//        {
//            itemsIndexed(toyList!!.results) { index, item ->
//                ToyCard(toy = item)
//            }
//        }
//    }
}
@Composable
fun ToyCard(toy: Toy){
    
    Row(modifier = Modifier.fillMaxWidth(.8f)) {

        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground)
            , contentDescription = null,
        modifier = Modifier.size(70.dp))

        Column {

            Text(toy.sName,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center)

            Spacer(Modifier.size(2.dp))

            Text(text = toy.sDescription,
            style = MaterialTheme.typography.body1)
        }
    }
}