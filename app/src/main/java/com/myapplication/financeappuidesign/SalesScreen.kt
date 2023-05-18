package com.myapplication.financeappuidesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapplication.financeappuidesign.ui.theme.*


data class MonthlySaledData(
    val month:String,
    val salesInThousand:Int
)

val year2020sales= mutableListOf(
    MonthlySaledData("Jan",32),
    MonthlySaledData("Feb",24),
    MonthlySaledData("Mar",35),
    MonthlySaledData("Apr",46),
    MonthlySaledData("May",27),
    MonthlySaledData("Jun",21),
    MonthlySaledData("Jul",12),
    MonthlySaledData("Aug",13),
    MonthlySaledData("Sep",44),
    MonthlySaledData("Oct",15),
    MonthlySaledData("Nov",11),
    MonthlySaledData("Dec",8)

)


@Composable()
    fun SalesScreen(){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(CustomDarkGray, CustomLightGreen)
                    )
                )
                .padding(25.dp)
        )
        {
           Row (
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween
                   ){
               IconButton(onClick = { /*TODO*/ }) {

                   Icon(painter = painterResource(id = R.drawable.more),
                       contentDescription = "more",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                       )

               }
               Box (
                   modifier = Modifier
                       .size(50.dp)
                       .border(
                           width = 1.dp,
                           color = CustomOrange,
                           shape = RoundedCornerShape(20.dp)
                       ),
                   contentAlignment = Alignment.Center
                       ){

                   Image(
                       modifier = Modifier
                           .clip(RoundedCornerShape(5.dp))
                           .size(40.dp),
                       painter = painterResource(id = R.drawable.david), contentDescription ="Profile Photo" )

               }

           }

            LazyRow(
                modifier = Modifier.height(250.dp),
                verticalAlignment = Alignment.Bottom
            ){
                items(year2020sales){ items->
                    SingleBar(monthlySaledData =items )
                    Spacer(modifier = Modifier.width(15.dp))
                }

            }

            Text(text="Sales Revenue",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 14.dp),
                     fontSize = 20.sp,
                     color=Color.White,
                    fontFamily = FontFamily(Font(R.font.ubuntu))
            )

            Row (
                modifier = Modifier.fillMaxWidth()
                    ){
                
                Column(modifier = Modifier.weight(1f)){
                    InfoCard(160.dp)
                    Spacer(modifier = Modifier.height(10.dp))
                    InfoCard(260.dp)

                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)){
                    InfoCard(160.dp)
                    Spacer(modifier = Modifier.height(10.dp))
                    InfoCard(260.dp)
                }

            }
        }

    }



@Composable
fun SingleBar(
    monthlySaledData: MonthlySaledData
){

    val largestSalesValue= year2020sales.maxOf {
        it.salesInThousand
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${monthlySaledData.salesInThousand}K",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.ubuntu)),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        Box (
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topEnd = 10.dp,
                        topStart = 10.dp
                    )
                )
                .background(
                    if (year2020sales.indexOf(monthlySaledData) % 2 == 0) {
                        CustomLightOrange
                    } else CustomCyan
                )
                .width(40.dp)
                .height(
                    (200 * monthlySaledData.salesInThousand / largestSalesValue).dp
                )
              

                )
        {

        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "${monthlySaledData.month}", color = Color.White,
        fontFamily = FontFamily(Font(R.font.ubuntu)),
            fontSize = 12.sp
        )

    }
}
@Composable

fun InfoCard(
    cardHeight: Dp){

    Box(
    modifier = Modifier.clip(RoundedCornerShape(30.dp))
        .fillMaxWidth()
        .height(cardHeight)
        .background(color = Color.White.copy(alpha = 0.1f)),
        contentAlignment = Alignment.Center

    ){
    
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(painter = painterResource(id = R.drawable.ic_sales), contentDescription ="",
            modifier = Modifier.size(25.dp),
            tint=Color.White)
            Text("23K",
            fontFamily = FontFamily(Font(R.font.ubuntu)),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text("Sales",
                fontFamily = FontFamily(Font(R.font.ubuntu)),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            
        }
    }
}


@Preview
@Composable
fun SalesScreenPreview(){
    SalesScreen()

}
