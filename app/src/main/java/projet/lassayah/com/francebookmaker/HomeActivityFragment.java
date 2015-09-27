package projet.lassayah.com.francebookmaker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LaMarseillaise on 9/27/2015.
 */
public class HomeActivityFragment extends Fragment {

    private View v;

    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.home, container, false);
        return v;
    }
}
