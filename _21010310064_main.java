package _21010310064_sezer_kilic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class _21010310064_main {

	public static void main(String[] args) throws FileNotFoundException {
		File fle= new File("FST.txt");
		Scanner dosya= new Scanner(fle);
		Scanner input = new Scanner(System.in);
		
		LinkedList<_21010310064_fst> states = new LinkedList<_21010310064_fst>();
		LinkedList<Integer> girdiler =new LinkedList<Integer>();
		
		dosyaOku(dosya,states,girdiler);
		dosya.next(); dosya.next();
		System.out.println("Lütfen birinci input’u giriniz:");
		write(input.next(), girdiler, states,dosya.next());
		input.close();

	}
	
	public static void baglantiOlustur(Scanner input, LinkedList<_21010310064_fst> states, LinkedList<Integer> girdiler) {
		for (int i = 0; i < states.size(); i++) {
			_21010310064_fst fst = states.get(i);
			input.next();
			for(int j=0;j<girdiler.size();j++) {
				String s=input.next().replace("(", "");
				s=s.replace(",", "");
				String g=input.next().replace(")", "");
				int cikti=Integer.parseInt(g);
				fst.baglantiEkle(getFst(s,states), girdiler.get(j), cikti);
			}
		}
	}

	public static void write(String s, LinkedList<Integer> girdiler, LinkedList<_21010310064_fst> states,String baslangic) {
		_21010310064_fst fst= getFst(baslangic,states);
		ArrayList<String> durumlar= new ArrayList<String>();
		String sonuc ="";
		for (int i = 0; i < s.length(); i++) {
			for(int j=0;j<girdiler.size();j++) {
				if (Character.getNumericValue(s.charAt(i)) == girdiler.get(j)) {
					durumlar.add(fst.state);
					sonuc=sonuc+fst.baglantiBul(girdiler.get(j)).cikisval;
					fst=fst.baglantiBul(girdiler.get(j)).diger;
				}
			}

		}
		durumlar.add(fst.state);
		System.out.println("durumların sırası:"+durumlar);
		System.out.println("çıktı: " +sonuc);

	}
	public static _21010310064_fst getFst(String state,LinkedList<_21010310064_fst> states) {
		for (int i = 0;i<states.size();i++) {
			if(states.get(i).state.equals(state)) {
				return states.get(i);
			}
		}
		return null;
	}
	public static void dosyaOku(Scanner input,LinkedList<_21010310064_fst> states, LinkedList<Integer> girdiler) {
		
		input.next();input.next();
		
		String s= input.next().replace("{","");
		while(!s.contains("}")) {
			s=s.replace(",", "");
			_21010310064_fst fstler = new _21010310064_fst(s);
			states.add(fstler);
			s=input.next();
		}
		s=s.replace("}","");
		_21010310064_fst sonfst = new _21010310064_fst(s);
		states.add(sonfst);
		
		input.next();input.next();
		
		String g= input.next().replace("{","");
		int girdi;
		while(!g.contains("}")) {
			g=g.replace(",", "");
			girdi=Integer.parseInt(g);
			girdiler.add(girdi);
			g=input.next();
		}
		g=g.replace("}","");
		girdi=Integer.parseInt(g);
		girdiler.add(girdi);
		
		input.nextLine(); input.nextLine(); input.nextLine();
		baglantiOlustur(input,states,girdiler);
		
		
	}

	
	
	
}