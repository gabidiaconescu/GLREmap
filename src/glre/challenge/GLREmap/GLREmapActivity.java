package glre.challenge.GLREmap;

import java.util.List;

import glre.challange.GLREmap.R;
import glre.challenge.model.Ville;
import glre.challenge.util.Search;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class GLREmapActivity extends Activity {
	
	private TextView tv;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tv = new TextView(this);
        // test comment here
        
        try
        {
        	List<Ville> villes = Search.getVilles(getResources().openRawResource(R.raw.villes));
        	for (int index = 0; index < villes.size(); index++)
        	   tv.append(villes.get(index).getName() + " " + villes.get(index).getLatitude() + " " + villes.get(index).getLongitude());
        	   
        }
        catch (Exception e)
        {
        	tv.setText(e.getMessage());
        }
        setContentView(tv);
    }
}