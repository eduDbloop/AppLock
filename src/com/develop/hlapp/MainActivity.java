package com.develop.hlapp;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
 

public class MainActivity extends FragmentActivity implements TabListener {
    
	 private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);

	        // Set up the action bar.
	        final android.app.ActionBar actionBar = getActionBar();
	        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

	        // For each of the sections in the app, add a tab to the action bar.
	        actionBar.addTab(actionBar.newTab().setText("ListFragment").setTabListener(this));
	        actionBar.addTab(actionBar.newTab().setText(R.string.title_section2).setTabListener(this));
	        actionBar.addTab(actionBar.newTab().setText(R.string.title_section3).setTabListener(this));
	    }

	    @Override
	    public void onRestoreInstanceState(Bundle savedInstanceState) {
	        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
	            getActionBar().setSelectedNavigationItem(
	                    savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
	        }
	    }

	    @Override
	    public void onSaveInstanceState(Bundle outState) {
	        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,
	                getActionBar().getSelectedNavigationIndex());
	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

	    

	    /**
	     * A dummy fragment representing a section of the app, but that simply displays dummy text.
	     */
	    public static class DummySectionFragment extends Fragment {
	        public DummySectionFragment() {
	        }

	        public static final String ARG_SECTION_NUMBER = "section_number";

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	            TextView textView = new TextView(getActivity());
	            textView.setGravity(Gravity.CENTER);
	            Bundle args = getArguments();
	            textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
	            return textView;
	        }
	    }



		@Override
		public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(Tab tab, android.app.FragmentTransaction fragmentTransaction) {
		        
		    	/**
		    	 * On first tab we will show our list
		    	 */
		    	if (tab.getPosition() == 0) {
		    		SimpleListFragment simpleListFragment = new SimpleListFragment();
		    		getSupportFragmentManager().beginTransaction().replace(R.id.container, simpleListFragment).commit();
		    	} else {
		    		/**
		    		 * Other tabs will show duffy fragments
		    		 */
		            Fragment fragment = new DummySectionFragment();
		            Bundle args = new Bundle();
		            args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
		            fragment.setArguments(args);
		            getSupportFragmentManager().beginTransaction()
		                    .replace(R.id.container, fragment)
		                    .commit();
		    	}
		    }			

		@Override
		public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

	}