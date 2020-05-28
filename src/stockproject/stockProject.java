package stockproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class stockProject {

	public static LinkedList<String[]> read() throws IOException {
		LinkedList<String[]> list= new LinkedList<String[]> ();
		File file = new File("/Users/apple/Documents/abc.txt");
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
		BufferedReader bfr=new BufferedReader(read);
		String s;
		int i=0;
		while ((s=bfr.readLine())!=null) {
			if(i==0) 
			{
			i++;
			continue;
			}
			String []j=s.split(",");
			String [] time= j[0].split("-");
			String date=time[0]+time[1];
			j[0]=date;
//			System.out.println(s);
			i++;
			list.add(j);
		}
		return list;
		}
	public static void count(LinkedList<String[]> list) {
		LinkedList<HashMap<String,Double>> finalend=new LinkedList<HashMap<String,Double>>();
		String datetarget="201801";
		Double high=0.0;
		Double low=0.0;
		Double end=0.0;
		Double end2=0.0;
		Double open=0.0;
		Double volume=0.0;
		Integer day=0;
		for(int i=0;i<list.size();i++) {
			String[] count = list.get(i);
			
			if(datetarget.equals(count[0])) {
				open+=Double.valueOf(count[1]);
				high+=Double.valueOf(count[2]);
				low+=Double.valueOf(count[3]);
				end+=Double.valueOf(count[4]);
				
				end2+=Double.valueOf(count[5]);
				volume+=Double.valueOf(count[6]);
				day++;
				if(i==list.size()-1) {
					Double openmean=open/day;
					Double openstd=open-openmean;
					Double highmean=high/day;
					Double highstd=high-highmean;
					Double lowmean=low/day;
					Double lowstd=low-lowmean;
					Double endmean=end/day;
					Double endstd=end-endmean;
					Double end2mean=end2/day;
					Double end2std=end2-end2mean;
					Double volumemean=volume/day;
					Double volumestd=volume-volumemean;
					System.out.println(datetarget+" 開盤月平均："+openmean+" 高點月平均："+highmean+" 低點月平均："+lowmean+" 關盤月平均："+endmean+" 調整關盤月平均："+end2mean+"成交量月平均:"+volumemean);
					
				}
				
			}
			else {
				Double openmean=open/day;
				Double openstd=open-openmean;
				Double highmean=high/day;
				Double highstd=high-highmean;
				Double lowmean=low/day;
				Double lowstd=low-lowmean;
				Double endmean=end/day;
				Double endstd=end-endmean;
				Double end2mean=end2/day;
				Double end2std=end2-end2mean;
				Double volumemean=volume/day;
				Double volumestd=volume-volumemean;
				System.out.println(datetarget+" 開盤月平均："+openmean+" 高點月平均："+highmean+" 低點月平均："+lowmean+" 關盤月平均："+endmean+" 調整關盤月平均："+end2mean+"成交量月平均:"+volumemean);
				System.out.println(datetarget+" 開盤標準差："+openstd+" 高點標準差："+highstd+" 低點標準差："+lowstd+" 關盤標準差："+endstd+" 調整關盤標準差："+end2std+"成交量標準差:"+volumestd);

				high=0.0;
				 low=0.0;
				 end=0.0;
				end2=0.0;
				open=0.0;		
				volume=0.0;
				day=0;
				datetarget=count[0];
			}
			

			
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		LinkedList<String[]> list = read();
		count(list);
		
	}

}
