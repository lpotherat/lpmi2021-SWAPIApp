package lpmi.potherat.promo2021.swapiapp.data;

import java.util.List;

import lpmi.potherat.promo2021.swapiapp.data.sw.People;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SWAPI {

    @GET("/api/people/")
    Call<List<People>> listPeople();

    @GET("/api/people/{id}/")
    Call<People> getOnePeople(@Path("id") Integer id);

}
