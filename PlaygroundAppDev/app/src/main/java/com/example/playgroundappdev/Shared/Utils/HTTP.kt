
import retrofit
import RetroFit

private const val BASE_URL = "https://api.thecatapi.com/v1/images/search";

val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()