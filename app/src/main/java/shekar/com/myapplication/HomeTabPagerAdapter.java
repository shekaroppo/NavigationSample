package shekar.com.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class HomeTabPagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = {"Track", "My Track"};

    public HomeTabPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                GenresFragment genresFragment = new GenresFragment();
                return genresFragment;
            case 1:
                MyMusicFragment myMusicListFragment = new MyMusicFragment();
                return myMusicListFragment;
        }
        return null;
    }
}