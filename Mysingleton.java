package ee.edu.jpk.elina.mang2;

import android.content.Context;

import com.android.volley.Request;
import  com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Mysingleton {
    private static Mysingleton mInstance;
    private RequestQueue requestQueue;
    private static Context mCtx;


    private Mysingleton (Context context)
    {
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    public static  synchronized Mysingleton getInstance (Context context)
    {
        if (mInstance==null)
        {
            mInstance = new Mysingleton(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {

        if (requestQueue==null)
        {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;

    }

    public <T>void addTorequestque(Request<T> request)
    {
        requestQueue.add(request);
    }

    // aitab vahendada infot ka klasside vahelisest infot. Saab olla ainult üks output.
}
