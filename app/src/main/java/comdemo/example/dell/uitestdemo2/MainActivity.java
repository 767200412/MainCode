package comdemo.example.dell.uitestdemo2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

import comdemo.example.dell.uitestdemo2.fragment.ContactsFragment;
import comdemo.example.dell.uitestdemo2.fragment.ManagementFragment;
import comdemo.example.dell.uitestdemo2.fragment.MeFragment;
import comdemo.example.dell.uitestdemo2.fragment.MessageFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private BottomNavigationView navigation;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //未选中时加载默认的图片
            refreshItemIcon();
            switch (item.getItemId()) {
                case R.id.tab_message:
                    //选中时加载选中的图片
                    item.setIcon(R.mipmap.home_ic_message_unormal);
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.tab_contacts:
                    //选中时加载选中的图片
                    item.setIcon(R.mipmap.home_ic_contacts_unormal);
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.tab_management:
                    //选中时加载选中的图片
                    item.setIcon(R.mipmap.home_ic_management_unormal);
                    mViewPager.setCurrentItem(2);
                    return true;
                case R.id.tab_me:
                    //选中时加载选中的图片
                    item.setIcon(R.mipmap.home_ic_me_unormal);
                    mViewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mViewPager=(ViewPager) findViewById(R.id.mViewPager);//获取到ViewPager
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setItemIconTintList(null);	//删除默认的选中效果

        //ViewPager的监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                navigation.getMenu().getItem(i).setChecked(true);
                //Log.e("id:",String.valueOf(navigation.getMenu().getItem(i).getItemId()));
                refreshItemIcon();
                //写滑动页面后做的事，使每一个fragmen与一个page相对应
                switch (navigation.getMenu().getItem(i).getItemId()) {
                    case R.id.tab_message:
                        //选中时加载选中的图片
                        navigation.getMenu().getItem(i).setIcon(R.mipmap.home_ic_message_unormal);
                        //mViewPager.setCurrentItem(0);
                        break;
                    case R.id.tab_contacts:
                        //选中时加载选中的图片
                        navigation.getMenu().getItem(i).setIcon(R.mipmap.home_ic_contacts_unormal);
                       // mViewPager.setCurrentItem(1);
                        break;
                    case R.id.tab_management:
                        //选中时加载选中的图片
                        navigation.getMenu().getItem(i).setIcon(R.mipmap.home_ic_management_unormal);
                       // mViewPager.setCurrentItem(2);
                        break;
                    case R.id.tab_me:
                        //选中时加载选中的图片
                        navigation.getMenu().getItem(i).setIcon(R.mipmap.home_ic_me_unormal);
                       // mViewPager.setCurrentItem(3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


        //Fragment列表，将fragment放入列表中，放入mPagerAdapter
        final ArrayList<Fragment> fgLists=new ArrayList<>(4);
        fgLists.add(new MessageFragment());
        fgLists.add(new ContactsFragment());
        fgLists.add(new ManagementFragment());
        fgLists.add(new MeFragment());
        FragmentPagerAdapter mPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fgLists.get(position);
            }

            @Override
            public int getCount() {
                return fgLists.size();
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(3);

    }


    /**
     * 未选中时加载默认的图片
     */
    public void refreshItemIcon() {
        MenuItem item1 =  navigation.getMenu().findItem(R.id.tab_message);
        item1.setIcon(R.mipmap.home_ic_message_normal);
        MenuItem item2 =  navigation.getMenu().findItem(R.id.tab_contacts);
        item2.setIcon(R.mipmap.home_ic_contacts_normal);
        MenuItem item3 =  navigation.getMenu().findItem(R.id.tab_management);
        item3.setIcon(R.mipmap.home_ic_management_normal);
        MenuItem item4 =  navigation.getMenu().findItem(R.id.tab_me);
        item4.setIcon(R.mipmap.home_ic_me_normal);

    }

}
