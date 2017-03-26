package crystalgems.popcorn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Alex on 25/03/2017.
 */

public class HomePageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private RecyclerView homeRecyclerView;
    private RecyclerView.LayoutManager homeLayoutManager;
    private RecyclerView.Adapter rvAdapter;


    private int mPage;

    //TODO : Replace with real data
    private String[] customDataset = {"Premier", "Deuxième", "Troisième", "Quatrième", "Cinquième", "Sixième", "Septième", "Huitième"};

    public static HomePageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment_page, container, false);

        homeRecyclerView = (RecyclerView) rootView.findViewById(R.id.movie_card_recycler_view);

        // Improve performance if we know components will have fixed size, which is the case
        homeRecyclerView.setHasFixedSize(true);

        homeLayoutManager = new GridLayoutManager(getContext(), 2);
        homeRecyclerView.setLayoutManager(homeLayoutManager);

        // specify an adapter to create views for items in the recycler view
        rvAdapter = new HomeRecyclerViewAdapter(customDataset);
        homeRecyclerView.setAdapter(rvAdapter);

        return rootView;
    }
}