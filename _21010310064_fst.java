package _21010310064_sezer_kilic;
  
   import java.util.LinkedList;
   import java.util.Objects;
   import java.util.Queue;

   public class _21010310064_fst {
   	String state;
   	LinkedList<_21010310064_baglanti> baglantilar;

   	_21010310064_fst(String state) {
   		this.state = state;
   		this.baglantilar= new LinkedList<_21010310064_baglanti>();
   	}


   	@Override
   	public int hashCode() {
   		return Objects.hash(state);
   	}

   	@Override
   	public boolean equals(Object obj) {

   		if (this == obj)
   			return true;
   		if (obj == null)
   			return false;
   		if (getClass() != obj.getClass())
   			return false;
   		_21010310064_fst other = (_21010310064_fst) obj;
   		return Objects.equals(state, other.state);
   	}
   	

   	public void baglantiEkle(_21010310064_fst diger, int giris, int cikis) {
   		_21010310064_baglanti b = new _21010310064_baglanti(this,diger, giris, cikis);
   		baglantilar.add(b);
   	}

   	public _21010310064_baglanti baglantiBul(int giris) {
   		for (int i = 0; i < baglantilar.size(); i++) {
   			if (baglantilar.get(i).girisval == giris) {
   				return baglantilar.get(i);
   			}
   		}
   		return null;
   	}

   }