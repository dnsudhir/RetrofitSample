package qubag.com.retrofitsample;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class CallApi extends AsyncTask<Void, Void, String> {

  private Context context;
  private Call<ResponseBody> call;
  private boolean dialog;
  private String title;
  private String message;
  private ProgressDialog progressDialog;
  private OnCallComplete onCallComplete;
  private String strResponse;

  public CallApi(Context context, Call<ResponseBody> call) {
    this.context = context;
    this.call = call;
  }

  public void setProgressDialog(boolean dialog) {
    this.dialog = dialog;
    title = "Please Wait";
    message = "Loading...";
  }

  public void setProgressDialog(boolean dialog, String title, String message) {
    this.dialog = dialog;
    this.title = title;
    this.message = message;
  }

  @Override protected void onPreExecute() {
    super.onPreExecute();
    if (dialog) {
      progressDialog = ProgressDialog.show(context, title, message);
    }
  }

  @Override protected String doInBackground(Void... voids) {
    try {
      strResponse = call.execute().body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return strResponse;
  }

  @Override protected void onPostExecute(String response) {
    super.onPostExecute(response);
    if (dialog && progressDialog.isShowing()) progressDialog.dismiss();
    onCallComplete.CallCompleted(response != null,
        response != null && !response.contentEquals("") ? response : null);
  }

  public void setCheckExecute(CallApi webCall, OnCallComplete onCallComplete) {
    ConnectivityManager cm =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
      this.onCallComplete = onCallComplete;
      webCall.execute();
    } else {
      AlertDialog.Builder builder = new AlertDialog.Builder(context);
      builder.setTitle("No Internet Connection");
      builder.setMessage("Please Check Your Internet Connection");
      builder.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialogInterface, int i) {
          ((AppCompatActivity) context).finish();
          context.startActivity((((AppCompatActivity) context).getIntent()));
        }
      });
      builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialogInterface, int i) {
          ((AppCompatActivity) context).finish();
        }
      });
      builder.setCancelable(false);
      builder.show();
    }
  }

  interface OnCallComplete {
    void CallCompleted(boolean b, String result);
  }
}
