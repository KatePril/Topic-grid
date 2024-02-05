package com.example.topicgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.topicgrid.model.Topic
import com.example.topicgrid.ui.theme.TopicGridTheme
import androidx.compose.foundation.lazy.items
import com.example.topicgrid.datasource.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopicGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Row(

    ) {
        Image(
            painter = painterResource(id = topic.topicImage),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.clip(
                shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp),

            )
        )
        Surface (
            color = Color(red = 208, green = 198, blue = 253, alpha = 255),
            modifier = Modifier.clip(
                shape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp)
            )
        ) {
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = stringResource(id = topic.topicName),
                    modifier = Modifier.padding(top = 5.dp)
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        text = topic.courseNumber.toString(),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }

    }

}

@Composable
fun TopicList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(topicList) { affirmation ->
            TopicCard(affirmation)
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TopicApp() {
    TopicGridTheme {
        TopicList(topicList = DataSource.topics)
    }
}