package com.revature.retrofitexample.view

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.revature.retrofitexample.R
import com.revature.retrofitexample.network.Toy
import com.revature.retrofitexample.viewmodel.BrowseToysViewModel

@Composable
fun BrowseToys(viewModel:BrowseToysViewModel){

    var lazyState = rememberLazyListState()


    var toyList = viewModel.allToys

//    if (toyList.isNotEmpty())
//    {
//        Text(
//            toyList.get(0).sName,
//            style = MaterialTheme.typography.subtitle1,
//            textAlign = TextAlign.Center
//        )
//    }

    LazyColumn(state = lazyState,
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){

        if (toyList.isNotEmpty())
        {
            itemsIndexed(toyList) { _, item ->
                ToyCard(toy = item)
            }
        }
    }
}
@Composable
fun ToyCard(toy: Toy){
    
    Row(modifier = Modifier.fillMaxWidth(.95f)) {

        Image(painter = rememberCoilPainter(
            request = toy.sImagePath)
            , contentDescription = null,
        modifier = Modifier.size(70.dp))

        Spacer(Modifier.size(5.dp))

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