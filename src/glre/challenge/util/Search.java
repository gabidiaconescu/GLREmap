package glre.challenge.util;

import glre.challenge.model.Ville;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class Search {

	public static List<Ville> getVilles(InputStream in) {
		
		List<Ville> list = new ArrayList<Ville>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    try {
	        String line;
	        String headers = reader.readLine();
	        
	        while ((line = reader.readLine()) != null) {
	             String[] RowData = line.split(",");
	             Ville ville = new Ville();
	             ville.setName(RowData[0]);
	             ville.setLatitude(Double.parseDouble(RowData[1]));
	             ville.setLongitude(Double.parseDouble(RowData[2]));
	             list.add(ville);
	        }
	    }
	    catch (IOException ex) {
	        Log.v("error", ex.getMessage());
	    }
	    finally {
	        try {
	            in.close();
	        }
	        catch (IOException e) {
	            // handle exception
	        }
	    }
	    
	    return list;
	}
}
