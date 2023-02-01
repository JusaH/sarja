package kanta;

/**
 * Tarkistaa hetun oikeellisuuden
 * @author jussi
 * @version 20.2.2019
 *
 */
public class HetuTarkistus {

    
    /**
     * 
     */
    public static final String TARKISTUSMERKIT = "0123456789ABCDEFHJKLMNPRSTUVWXY";
    
    
    
    /**
     * luo satunnaisen kokonaisluvun rajojen sisällä
     * @param min alaraja
     * @param max yläraja
     * @return random kokonaisluku
     */
    public static int rand(int min, int max) {
        double n = (max-min)*Math.random()+min;
        return (int)Math.round(n);
    }

/**
 * LUENTO 13 55:30
 * @param hetu hetu
 * @return tarkistusmerkki
 */
public static char hetunTarkistusMerkki(String hetu) {
    String pvm=hetu.substring(0,6);
    String yksilo = hetu.substring(7,10);
    long luku= Long.parseLong(pvm+yksilo);
    int jakojaannos = (int)(luku % 31L);
    return TARKISTUSMERKIT.charAt(jakojaannos);
}

     /**
     * arpoo henkilötunnuksen
     * @return hetu
     */
    public static String arvoHetu() {
          String apuhetu = String.format("%02d",rand(1,28))   +
          String.format("%02d",rand(1,12))   +
          String.format("%02d",rand(1,99))   + "-" +
          String.format("%03d",rand(1,1000));
          return apuhetu + hetunTarkistusMerkki(apuhetu);        
      }

    	/**
    	 * Tarkistaa onko hetu oikein.
    	 * @param hetu tarkistettava hetu
    	 * @return true jos hetu on oikein, false jos v��rin.
    	 */
	public static boolean tarkista(String hetu) {
		if(hetu.charAt(hetu.length()-1)==hetunTarkistusMerkki(hetu))return true;
		return false;
	}

}