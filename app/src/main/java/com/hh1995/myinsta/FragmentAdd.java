package com.hh1995.myinsta;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.content.CursorLoader;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FragmentAdd extends Fragment {
    ImageView iv;

    EditText etTitle;
    EditText etMsg;

    Button btnImg;
    Button btnComplete;

    String imgPath;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_add,container,false);
        iv=view.findViewById(R.id.iv);
        etTitle=view.findViewById(R.id.et_title);
        etMsg=view.findViewById(R.id.et_msg);
        btnImg=view.findViewById(R.id.imgAdd);
        btnComplete=view.findViewById(R.id.addComplete);

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,10);
            }
        });

        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=etTitle.getText().toString();
                String msg=etMsg.getText().toString();

                Retrofit retrofit=RetrofitHelper.getInstance2();
                RetrofitService retrofitService=retrofit.create(RetrofitService.class);

                Map<String, String> dataPart=new HashMap<>();
                dataPart.put("title",title);
                dataPart.put("msg",msg);

                MultipartBody.Part filePart=null;
                if (imgPath!=null){
                    File file=new File(imgPath);
                    RequestBody requestBody=RequestBody.create(MediaType.parse("image/*"),file);
                    filePart=MultipartBody.Part.createFormData("img",file.getName(),requestBody);

                    Call<String> call=retrofitService.postDataToHome(dataPart,filePart);
                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(getContext(), "저장", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(getContext(), t+"실패", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10 &&resultCode==-1){
            Uri uri=data.getData();
            if (uri != null) {
                Glide.with(getContext()).load(uri).into(iv);
                imgPath=getRealPathFromUri(uri);
            }
        }
    }
    String getRealPathFromUri(Uri uri){
        String[] proj= {MediaStore.Images.Media.DATA};
        CursorLoader loader= new CursorLoader(getContext(), uri, proj, null, null, null);
        Cursor cursor= loader.loadInBackground();
        int column_index= cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result= cursor.getString(column_index);
        cursor.close();
        return  result;
    }
}
