package qubag.com.retrofitsample;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Login {
  @FormUrlEncoded @POST("login.php") Call<Customer> verifyLogin(@Field("phone_no") String phone_no);
}
