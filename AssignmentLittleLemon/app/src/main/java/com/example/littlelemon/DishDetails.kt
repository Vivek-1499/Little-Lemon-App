package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DishDetails(id: Int) {
    val dish = requireNotNull(DishRepository.getDish(id)) {
        "Dish not found"
    }
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        TopAppBar()
        Image(
            painter = painterResource(id = dish.imageResource),
            contentDescription = "Dish image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            Text(
                text = dish.name,
                style = MaterialTheme.typography.h3
            )
            Text(
                text = dish.description,
                style = MaterialTheme.typography.body1
            )
            Counter()
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = stringResource(id = R.string.add_for, dish.price),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun Counter() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        var counter by remember { mutableStateOf(1) }
        TextButton(
            onClick = {
                if (counter > 1) counter--
            }
        ) {
            Text(
                text = "-",
                style = MaterialTheme.typography.h4
            )
        }
        Text(
            text = counter.toString(),
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        TextButton(
            onClick = {
                counter++
            }
        ) {
            Text(
                text = "+",
                style = MaterialTheme.typography.h4
            )
        }
    }
}

@Preview
@Composable
fun DishDetailsPreview() {
        DishDetails(id = 1)
}
