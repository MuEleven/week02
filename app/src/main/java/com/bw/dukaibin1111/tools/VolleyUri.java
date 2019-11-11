package com.bw.dukaibin1111.tools;

public class VolleyUtils {
    private RequestQueue mQueue;

    private VolleyUtils() {
        mQueue = Volley.newRequestQueue(MyApp.mContext);
    }

    private static class VolleyHolder {
        private static final VolleyUtils volley = new VolleyUtils();
    }

    public static VolleyUtils getInstance() {
        return VolleyHolder.volley;
    }

    public void getInfo(String url, final VolleyCallback callback) {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    String newResponse = new String(response.getBytes("iso-8859-1"), "utf-8");
                    callback.onSuccess(newResponse);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError(error.getMessage());
            }
        });
        mQueue.add(stringRequest);
    }

    //判断网络状态的方法
    public interface VolleyCallback {
        void onSuccess(String jsonStr);

        void onError(String error);
    }

}
