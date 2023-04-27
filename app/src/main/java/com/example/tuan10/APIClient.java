    package com.example.tuan10;

    import retrofit2.Retrofit;
    import retrofit2.Retrofit;
    import retrofit2.converter.gson.GsonConverterFactory;
    public class APIClient {

        private static APIClient instance = null;

        private final Api myApi;

        private APIClient(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myApi = retrofit.create(Api.class);
        }

        public static synchronized APIClient getInstance(){
            if (instance == null)
            {
                instance = new APIClient();
            }
             return instance;
        }
        public  Api getMyApi() {return myApi;}

    }
