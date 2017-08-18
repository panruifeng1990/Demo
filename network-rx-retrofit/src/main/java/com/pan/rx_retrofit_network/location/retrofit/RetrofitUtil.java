package com.pan.rx_retrofit_network.location.retrofit;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.util.Log;

import com.pan.rx_retrofit_network.SharePreferenceUtil;
import com.pan.rx_retrofit_network.converter.GsonConverterFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


/**
 * Created by Sunflower on 2015/11/4.
 */
public class RetrofitUtil {
    /**
     * 服务器地址
     */
    private static String API_HOST;
    private static Context mContext;
    private static String token;
    private static SharePreferenceUtil sp;
    public static void init(String baseUrl, Application context) {
        if (TextUtils.isEmpty(baseUrl)) {
            return;
        }
        mContext = context;
        API_HOST = baseUrl;
        sp = new SharePreferenceUtil(context,"headerInfo");
    }

    public static Retrofit getInstance() {
        return Instance.retrofit;
    }

    private static class Instance {
        private static Retrofit retrofit = getRetrofit();

        private static Retrofit getRetrofit() {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(
//                    new HttpLoggingInterceptor.Logger() {
//                @Override
//                public void log(String message) {
//                    Log.i("RxJava", message);
//                }
//            }
            );
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            Interceptor cacheInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    //拿到请求体
                    Request request = chain.request();
                    Request newRequest = request.newBuilder().addHeader("loginEntry","1").build();
                    //读接口上的@Headers里的注解配置
                    String cacheControl = newRequest.cacheControl().toString();
                    //判断没有网络并且添加了@Headers注解,才使用网络缓存.
                    if (!isOpenInternet(mContext) && !TextUtils.isEmpty(cacheControl)) {
                        //重置请求体;
                        newRequest = newRequest.newBuilder()
                                //强制使用缓存
                                .cacheControl(CacheControl.FORCE_CACHE)
                                .build();
                    }
                    //如果没有添加注解,则不缓存
//                    if (TextUtils.isEmpty(cacheControl) || "no-store".contains(cacheControl)) {
//                        //响应头设置成无缓存
//                        cacheControl = "no-store";
//                    } else
                        if (isOpenInternet(mContext)) {
                        //如果有网络,则将缓存的过期时间,设置为0,获取最新数据
                        cacheControl = "public, max-age=" + 0;
                    } else {
                        //...如果无网络,则根据@headers注解的设置进行缓存.
                        cacheControl = "public, only-if-cached,max-stale=" + 60;

                    }

                    Response response = chain.proceed(newRequest);
                    Log.i("httpInterceptor", cacheControl);
                    return response.newBuilder()
                            .header("Cache-Control", cacheControl)
                            .removeHeader("Pragma")
                            .build();
                }
            };
            File filepath = mContext.getCacheDir();
            Log.d("prf","filepath = "+ filepath);
            OkHttpClient client = new OkHttpClient.Builder()
//                    //添加header请求
                    .addInterceptor(HEADER_INTERCEPTOR)
                    //拦截并设置缓存
                    .addNetworkInterceptor(REWRITE_RESPONSE_INTERCEPTOR)
                    //拦截并设置缓存
                    .addInterceptor(REWRITE_RESPONSE_INTERCEPTOR_OFFLINE)
                    .cache(new Cache(filepath, 10240 * 1024))
                    .build();
            return new Retrofit.Builder()
                    .client(client)
                    .baseUrl(API_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }


        /**
         * 生成对应的RequestBody
         *
         * @param param 参数
         * @return RequestBody
         */
        public static RequestBody createRequestBody(int param) {
            return RequestBody.create(MediaType.parse("text/plain"), String.valueOf(param));
        }

        public static RequestBody createRequestBody(long param) {
            return RequestBody.create(MediaType.parse("text/plain"), String.valueOf(param));
        }

        public static RequestBody createRequestBody(float param) {
            return RequestBody.create(MediaType.parse("text/plain"), String.valueOf(param));
        }

        public static RequestBody createRequestBody(Object param) {
            return createRequestBody(String.valueOf(param));
        }

        public static RequestBody createRequestBody(double param) {
            return RequestBody.create(MediaType.parse("text/plain"), String.valueOf(param));
        }

        public static RequestBody createRequestBody(String param) {
            return RequestBody.create(MediaType.parse("text/plain"), param);
        }

        protected RequestBody createRequestBody(File param) {
            return RequestBody.create(MediaType.parse("image/*"), param);
        }

        public static HashMap<String, RequestBody> createRequestBody(HashMap<String, Object> params) {
            HashMap<String, RequestBody> RequestBodyHashMap = new HashMap<>();
            Set<String> strings = params.keySet();
            for (String str : strings) {
                Object param = params.get(str);
                RequestBodyHashMap.put(str, createRequestBody(param));
            }
            return RequestBodyHashMap;
        }

        /**
         * 次方法获取的bitmap为原始大小,图片文件过大可能造成oom
         *
         * @param images
         * @return
         */
        public static HashMap<String, RequestBody> creatRequestBodyImagesFiles(List<String> images) throws OutOfMemoryError {
            if (images == null) {
                return null;
            }
            HashMap<String, RequestBody> photoRequestMap = new HashMap<>();
            int size = images.size();
            for (int i = 0; i < size; i++) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = BitmapFactory.decodeFile(images.get(i));
                //转化为二进制流数组
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                bitmap.recycle();
                photoRequestMap.put("file" + i + "\";filename=\"" +
                        System.currentTimeMillis(), RequestBody.create(MediaType.parse("multipart/form-data"), byteArray));
            }
            return photoRequestMap;
        }

        /**
         * 建议调用此方法前,先将bitmap压缩.
         *
         * @param images
         * @return
         */
        public static HashMap<String, RequestBody> creatRequestBodyBitmap(List<Bitmap> images) {
            if (images == null) {
                return null;
            }
            HashMap<String, RequestBody> photoRequestMap = new HashMap<>();
            int size = images.size();
            for (int i = 0; i < size; i++) {
                Bitmap bitmap = images.get(i);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                //转化为二进制流数组
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                photoRequestMap.put("file" + i + "\";filename=\"" +
                        System.currentTimeMillis(), RequestBody.create(MediaType.parse("multipart/form-data"), byteArray));
            }
            return photoRequestMap;
        }
    }

    /**
     * 判断网络是否打开
     *
     * @return
     */
    public static boolean isOpenInternet(Context context) {
        ConnectivityManager con = (ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE);
        boolean wifi = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        boolean intenter = con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
        return wifi || intenter;
    }

    private static final int TIMEOUT_CONNECT = 5; //5秒
    private static final int TIMEOUT_DISCONNECT = 60 * 60 * 24 * 7; //7天

    public static final Interceptor REWRITE_RESPONSE_INTERCEPTOR = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            //获取retrofit @headers里面的参数，参数可以自己定义，在本例我自己定义的是cache，跟@headers里面对应就可以了
            String cache = chain.request().header("cache");
            okhttp3.Response originalResponse = chain.proceed(chain.request());
            String cacheControl = originalResponse.header("Cache-Control");
            //如果cacheControl为空，就让他TIMEOUT_CONNECT秒的缓存，本例是5秒，方便观察。注意这里的cacheControl是服务器返回的
            if (cacheControl == null) {
                //如果cache没值，缓存时间为TIMEOUT_CONNECT，有的话就为cache的值
                if (cache == null || "".equals(cache)) {
                    cache = TIMEOUT_CONNECT + "";
                }
                originalResponse = originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + cache)
                        .build();
                return originalResponse;
            } else {
                return originalResponse;
            }
        }
    };

    public static final Interceptor REWRITE_RESPONSE_INTERCEPTOR_OFFLINE = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //离线的时候为7天的缓存。
            if (!isOpenInternet(mContext)) {
                request = request.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale="+TIMEOUT_DISCONNECT)
                        .build();
            }
            return chain.proceed(request);
        }
    };


    /** 当前版本号 */
    public static String version = "";
    /** VersionCode */
    public static int versionCode;

    private static Context context;
    /** 设备唯一标识 */
    public static String imei = "";
    /** 手机系统版本 */
    public static final String osVersion = android.os.Build.VERSION.RELEASE;
    /** 手机型号 */
    public static final String model = android.os.Build.MODEL;
    /** 手机号 */
    public static String phonenumber = "";
    public static final Interceptor HEADER_INTERCEPTOR = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();

            builder.addHeader("loginEntry", "1");
            if (!TextUtils.isEmpty(sp.getString("token", "")))
            builder.addHeader("token", "5b751447c91f4023b043bd0e23909f02");
            builder.addHeader("APPVERSION", version);// 版本号
            builder.addHeader("DEVICEID", imei);// 手机串号
            builder.addHeader("DEVICETYPE", model);// 手机型号
            builder.addHeader("OSVERSION", osVersion);// 手机系统版本
            builder.addHeader("APPNAME", "moshou");
            if (!TextUtils.isEmpty(sp.getString("cityName", ""))) {
                try {
                    builder.addHeader("city", URLEncoder.encode(sp.getString("cityName", ""), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            builder.addHeader("deviceSource", "1");
            Request request = builder.build();
            return chain.proceed(request);
        }
    };
}
