package com.example.chsamirkrishna.railwayapistation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PnrStatusAPI {

    @GET("v2/pnr-status/pnr/{pnrno}/apikey/af9h4f4eho/")
    Call<PnrStatus> getPnrStatus(@Path("pnrno")String pno);
}
