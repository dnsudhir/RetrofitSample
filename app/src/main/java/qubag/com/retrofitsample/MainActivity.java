package qubag.com.retrofitsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  private ListView listView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listView = (ListView) findViewById(R.id.listView);

    mGetRepos();
  }

  private void mGetRepos() {
    ServiceGenerator serviceGenerator = new ServiceGenerator();
    GitHubClient client = serviceGenerator.createService(GitHubClient.class);

    Call<List<GitHubRepo>> call = client.reposForUser("fs-opensource");

    call.enqueue(new Callback<List<GitHubRepo>>() {
      @Override
      public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
        List<GitHubRepo> repos = response.body();

        listView.setAdapter(new GitHubRepoAdapter(MainActivity.this, repos));
      }

      @Override public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
        Toast.makeText(MainActivity.this, "Retrofit WebCall Failed", Toast.LENGTH_SHORT).show();
      }
    });
  }
}
