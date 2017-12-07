package qubag.com.retrofitsample;

import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {
  @GET("/users/{user}/repos") Call<List<GitHubRepo>> reposForUser(@Path("user") String user);

  @GET("/users/{user}/repos") Call<ResponseBody> repos(@Path("user") String user);
}
