package com.musicshow.client;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.musicshow.client.fragment.TopicListFragment;
import com.musicshow.client.fragment.TopicListFragment.listViewUpdating;
import com.musicshow.widget.SlideView;
import com.musicshow.widget.SlideView.OnSlideListener;

public class MainActivity extends FragmentActivity implements listViewUpdating, OnItemClickListener, OnClickListener,
OnSlideListener {

	ListView mListView;
    private static final String TAG = "MainActivity";
    private SlideView mLastSlideViewWithStatusOn;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_list_fragment);

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            TopicListFragment firstFragment = new TopicListFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
	}

	@Override
	public void bindListData(ListView listView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSlide(View view, int status) {
        if (mLastSlideViewWithStatusOn != null && mLastSlideViewWithStatusOn != view) {
            Log.e(TAG, "onSlide shrink");
            mLastSlideViewWithStatusOn.shrink();
        }

        if (status == SLIDE_STATUS_ON) {
            Log.e(TAG, "onSlide ON");
            mLastSlideViewWithStatusOn = (SlideView) view;
        }
		
	}

	@Override
	public void onClick(View v) {
        if (v.getId() == R.id.holder) {
            Log.e(TAG, "onClick v=" + v);
        }
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
        Log.e(TAG, "onItemClick position=" + position);
		
	}

}
