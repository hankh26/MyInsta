package com.hh1995.myinsta;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

public class FragmentAdd extends Fragment {
    ImageView iv;

    EditText etTitle;
    EditText etMsg;

    Button btnImg;
    Button btnComplete;

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

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10 &&resultCode==-1){
            Uri uri=data.getData();
            if (uri != null) {
                Glide.with(getContext()).load(uri).into(iv);
            }
        }
    }
}
