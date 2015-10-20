package projet.lassayah.com.francebookmaker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by LaMarseillaise on 9/27/2015.
 */
public class HomeActivityFragment extends Fragment {

    private View v;
    private Button ranking;

    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);
        ranking = (Button) v.findViewById(R.id.button_points);

        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment rankingFragment = new RankingFragment();
                showOtherFragment(rankingFragment);
            }
        });

        return v;
    }

    public void showOtherFragment(Fragment f)
    {
        FragmentListener fc= (FragmentListener) getActivity();
        fc.replaceFragment(f);
    }

}
