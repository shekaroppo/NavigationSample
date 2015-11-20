package shekar.com.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Shekar on 7/27/15.
 */
public class GenresFragment extends Fragment  {

    @Bind(R.id.next)
    Button mNext;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_genres_list, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMusicList(true);
            }
        });
    }

    private void navigateToMusicList(boolean addToBackStack) {
        Log.d("navigateToMusicList ==:",getActivity().getSupportFragmentManager().getBackStackEntryCount()+" ");
        MusicListFragment fragment = getGenreFragment();
        if (fragment == null) {
            fragment = new MusicListFragment();
            android.support.v4.app.FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment, "MusicList");
            // If this is not the top level media (root), we add it to the fragment back stack,
            // so that actionbar toggle and Back will work appropriately:
            if (addToBackStack) {
                transaction.addToBackStack(null);
            }
            transaction.commit();
        }
    }
    private MusicListFragment getGenreFragment() {
        return (MusicListFragment) getActivity().getSupportFragmentManager().findFragmentByTag("MusicList");
    }
}
