
import retrofit
import RetroFit

//private const val BASE_URL = "https://api.thecatapi.com/v1/images/search";
private const val BASE_URL = "https://api.thecatapi.com";

val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

interface HttpService {
        @GET("/v1/images/search")
        //fun getImagesAsync():

        //@POST("")
        //@HEADERS("")
        //fun createImagesAsync()
}

object HttpApi {
        val retrofitService: HttpService by lazy {
                retrofit.create(HttpService::class.java)
        }
}