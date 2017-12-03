package qubag.com.retrofitsample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class GitHubRepoAdapter extends BaseAdapter {

  private Context context;
  private List<GitHubRepo> repos;

  public GitHubRepoAdapter(Context context, List<GitHubRepo> repos) {
    this.context = context;
    this.repos = repos;
  }

  @Override public int getCount() {
    return repos.size();
  }

  @Override public Object getItem(int i) {
    return repos.get(i);
  }

  @Override public long getItemId(int i) {
    return i;
  }

  @Override public View getView(int i, View view, ViewGroup viewGroup) {

    Holder holder;
    if (view == null) {
      view = View.inflate(context, R.layout.list_item, null);
      holder = new Holder();
      holder.tvRepoId = (TextView) view.findViewById(R.id.tvRepoId);
      holder.tvRepoName = (TextView) view.findViewById(R.id.tvRepoName);
      view.setTag(holder);
    } else {
      holder = (Holder) view.getTag();
    }

    holder.tvRepoId.setText(String.valueOf(repos.get(i).getId()));
    holder.tvRepoName.setText(repos.get(i).getName());
    return view;
  }

  private static class Holder {
    TextView tvRepoId, tvRepoName;
  }
}
