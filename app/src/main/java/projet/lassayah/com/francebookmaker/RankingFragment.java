package projet.lassayah.com.francebookmaker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.JsonHttpResponseHandler;
import cz.msebera.android.httpclient.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.NameValuePair;
import objet.Points;

/**
 * Created by LaMarseillaise on 10/13/2015.
 */
public class RankingFragment extends Fragment {

    private View v;
    private RecyclerView listPoints;
    private RecyclerView.LayoutManager layoutPoints;
    private RecyclerView.Adapter adapterPoints;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_points, container, false);
        listPoints = (RecyclerView)v.findViewById(R.id.listPoints);
        listPoints.setHasFixedSize(true);
        layoutPoints = new LinearLayoutManager(getActivity());
        listPoints.setLayoutManager(layoutPoints);
        callRanking();
        return v;
    }

    public void callRanking()
    {
        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://assayah.com/Brazil/webservices/points.php", params, new JsonHttpResponseHandler() {
            // When the response returned by REST has Http response code '200'
            @Override
            public void onSuccess(int i, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                System.out.println("test");

            }

            // cas de réponse du serveur sans erreur
            @Override
            public void onSuccess(int i, Header[] headers, JSONArray response) {

                List<Points> points = new ArrayList<Points>();
                for (int j = 0; j <response.length(); j++)
                {
                    JSONObject jsonObject;
                    try {
                        jsonObject = response.getJSONObject(j);
                        System.out.println(jsonObject);
                        Points point = new Points(jsonObject.getString("user"), Integer.valueOf(jsonObject.getString("points")), jsonObject.getString("rank"));
                        points.add(point);

                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


                }
                adapterPoints = new PointsAdapter(points);
                listPoints.setAdapter(adapterPoints);
            }


        });
    }

}
