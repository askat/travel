package com.example.travel.constants

import com.example.travel.R
import com.example.travel.model.Place
import com.example.travel.ui.theme.grey_100

val mockData = listOf(
    Place(
        id = 1,
        name = "Karakol Valley",
        summary = "Park",
        description = "Desc",
        location = "Kyrgystan",
        image = R.drawable.karakol_valley,
        time = "8 часов"
    ),
    Place(
        id = 2,
        name = "Ala-Kul Lake",
        summary = "Park",
        description = "Desc",
        location = "Kyrgystan",
        image = R.drawable.alakul,
        time = "24 часа"
    ),
    Place(
        id = 3,
        name = "Tian-Shan Range",
        summary = "Park",
        description = "Desc",
        location = "Kyrgystan",
        image = R.drawable.tian_shan_ragne,
        isFavorite = true,
        time = "8 часов"
    ),
    Place(
        id = 4,
        name = "Ala-Archa Park",
        summary = "Park",
        description = "Национальный парк Ала-Арча — одно из самых живописных мест Кыргызстана, расположенное в 40 километрах от Бишкека. Он занимает территорию около 200 квадратных километров и включает в себя ущелья, ледники, водопады и альпийские луга. Название парка происходит от местного растения арча, которое широко распространено в этих горах. Здесь можно увидеть величественные вершины Тянь-Шаня, покрытые вечными снегами. Одной из самых высоких точек является пик Семёнова-Тянь-Шанского, достигающий 4895 метров.\n" +
                "\n" +
                "Парк популярен среди туристов, альпинистов и любителей активного отдыха. Здесь проложены маршруты разной сложности — от лёгких прогулочных троп до сложных альпинистских восхождений. Одно из самых известных мест — водопад Аксай, привлекающий своей красотой. В Ала-Арче можно встретить редких животных, таких как снежный барс, горный козёл и орёл-беркут. В лесах парка растут тянь-шаньская ель и арча, создавая уникальный природный ландшафт.\n" +
                "\n" +
                "Весной и летом парк утопает в зелени и цветах, а осенью покрывается золотыми оттенками. Зимой Ала-Арча превращается в популярное место для лыжных прогулок и зимнего альпинизма. На территории парка находится альпинистская база «Рацек», откуда начинаются маршруты к горным вершинам. Чистый воздух, потрясающие виды и разнообразие природных ландшафтов делают это место идеальным для отдыха. Национальный парк Ала-Арча — настоящая жемчужина Кыргызстана, привлекающая путешественников круглый год.",
        location = "Kyrgystan",
        image = R.drawable.ala_archa_park,
        time = "8 часов"
    ),
    Place(
        id = 5,
        name = "Tulpar Kul",
        summary = "Park",
        description = "Desc",
        location = "Kyrgystan",
        image = R.drawable.tulpar_kul,
        time = "8 часов"
    )
)

val shimmerColors = listOf(
    grey_100.copy(alpha = 0.1f),
    grey_100.copy(alpha = 0.3f),
    grey_100.copy(alpha = 0.5f),
    grey_100.copy(alpha = 1.0f),
    grey_100.copy(alpha = 0.5f),
    grey_100.copy(alpha = 0.3f),
    grey_100.copy(alpha = 0.1f),
)