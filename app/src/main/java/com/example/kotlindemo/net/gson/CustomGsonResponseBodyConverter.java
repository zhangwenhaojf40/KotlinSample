package com.example.kotlindemo.net.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by agui on 20/12/2017.
 */

final class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private Gson gson;
    private final TypeAdapter<T> adapter;

    CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {

            JSONObject object = new JSONObject(value.string());
            ByteArrayInputStream inputStream=new ByteArrayInputStream(object.toString().getBytes());
            Reader reader = new InputStreamReader(inputStream);
            JsonReader jsonReader = new JsonReader(reader);
            return adapter.read(jsonReader);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            value.close();
        }
        return null;

    }
}

