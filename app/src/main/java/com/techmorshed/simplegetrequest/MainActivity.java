package com.techmorshed.simplegetrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private JsonPlaceHolderAPI placeHolderAPI;
    private TextView showData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showData = findViewById(R.id.view_post_data);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        placeHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);


//        getPosts();
//        getComments();
//        createPost();
        updatePost();
//        delete();
    }



    private void getPosts() {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("userId", "4");
        parameters.put("_sort", "id");
        parameters.put("_order", "desc");


        Call<List<Post>> call = placeHolderAPI.getPosts(parameters);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    showData.setText(response.code());
                    return;
                }
                List<Post> posts = response.body();

                for (Post post : posts) {

                    String value = "";

                    value += "ID : " + post.getId() + "\n";
                    value += "User ID : " + post.getUserId() + "\n";
                    value += "Title : " + post.getmTitle() + "\n";
                    value += "Body : " + post.getmBody() + "\n" + "\n";

                    showData.append(value);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                showData.setText(t.getMessage());
            }
        });

    }


    private void getComments() {

        Call<List<Comment>> call = placeHolderAPI.getComments("posts/1/comments");

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if (!response.isSuccessful()) {
                    showData.setText(response.code());
                    return;
                }

                List<Comment> comments = response.body();

                for (Comment comment : comments) {

                    String value = "";
                    value += "Id: " + comment.getId() + "\n";
                    value += "Post Id: " + comment.getPostId() + "\n";
                    value += "Name: " + comment.getName() + "\n";
                    value += "Email: " + comment.getEmail() + "\n";
                    value += "Body: " + comment.getText() + "\n\n\n";

                    showData.append(value);

                }


            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                showData.setText(t.getMessage());
            }
        });


    }


    private void createPost() {

        Map<String,String> postData = new HashMap<>();
        postData.put("userId","33");
        postData.put("title","new text");
        postData.put("body","next body");
        Call<Post> call = placeHolderAPI.createPost(postData);
//        Call<Post> call = placeHolderAPI.createPost(23,"Morshed how are you","there is something going");

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    showData.setText(response.code());
                    return;
                }

                Post responeBody = response.body();

                String value = "";
                value = "code : " + response.code() + "\n";
                value += "ID : " + responeBody.getId() + "\n";
                value += "User ID : " + responeBody.getUserId() + "\n";
                value += "Title : " + responeBody.getmTitle() + "\n";
                value += "Body : " + responeBody.getmBody() + "\n" + "\n";

                showData.setText(value);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                showData.setText(t.getMessage());
            }
        });

    }

    private void updatePost() {

        Post post = new Post(12,"Morsed",null);

        Call<Post> call = placeHolderAPI.putPost(6,post);
//        Call<Post> call = placeHolderAPI.patchPost(1,post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {


                if (!response.isSuccessful()) {
                    showData.setText(response.code());
                    return;
                }

                Post responeBody = response.body();

                String value = "";
                value = "code : " + response.code() + "\n";
                value += "ID : " + responeBody.getId() + "\n";
                value += "User ID : " + responeBody.getUserId() + "\n";
                value += "Title : " + responeBody.getmTitle() + "\n";
                value += "Body : " + responeBody.getmBody() + "\n" + "\n";

                showData.setText(value);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                showData.setText(t.getMessage());

            }
        });

    }


    private void delete() {

        Call<Void> call = placeHolderAPI.deletePost(4);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                showData.setText("Code: "+response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showData.setText(t.getMessage());

            }
        });

    }


}
