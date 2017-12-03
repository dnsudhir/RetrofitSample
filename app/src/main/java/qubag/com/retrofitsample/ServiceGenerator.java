package qubag.com.retrofitsample;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

  private static final String ROOT_URL = "https://api.github.com/";

  private static Retrofit.Builder builder =
      new Retrofit.Builder().baseUrl(ROOT_URL).addConverterFactory(GsonConverterFactory.create());

  private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

  private static Retrofit retrofit = builder.client(httpClient.build()).build();

  public static <S> S createService(Class<S> serviceClass) {
    return retrofit.create(serviceClass);
  }
}
