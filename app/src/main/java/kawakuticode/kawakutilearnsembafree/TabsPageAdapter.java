package kawakuticode.kawakutilearnsembafree;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

/**
 * Created by Russelius on 02/02/15.
 */
public class TabsPageAdapter  extends FragmentPagerAdapter {

    public TabsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public ListFragment getItem(int index) {

        switch (index) {

            case 0:
                // Top Rated fragment activity
                return new BeginnersLevel();
            case 1:
                // Games fragment activity
                return new IntermediaLevel();
            case 2:
                // Movies fragment activity
                return new ConfirmedLevel();

        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
