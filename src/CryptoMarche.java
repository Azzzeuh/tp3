import java.util.ArrayList;

public class CryptoMarche {

    private ArrayList<PorteFeuille> portefeuilles;
    private static CryptoMarche marche;

    private CryptoMarche(){
        portefeuilles = new ArrayList<PorteFeuille>();
    }

    public static CryptoMarche getInstance(){
        if(marche == null){ marche = new CryptoMarche();}
		return marche;
    }

    public void ajouter(PorteFeuille p){
        portefeuilles.add(p);
    }

    public double capitalEnEuros(String proprietaire){
    	double capital = 0;
    	
        for( PorteFeuille p : portefeuilles) 
        	if(p.getProprietaire().equals(proprietaire))
        		capital = p.getMontant();

        return capital;
    }

    /**
     * Cette fonction recherche sur le marchÃ© tous les portefeuilles 
     * d'un type de devise et calcule le volume total de capital de 
     * cette devise sur le marchÃ© 
     * @param monnaie
     * @return capital total en circulation de la cryptomonnaie (en euros).
     */
    public double capitalMonnaie(Cryptomonnaie monnaie){
    	double capitalTotal = 0;
        for( PorteFeuille p : portefeuilles)
        	if(p.getMonnaie() == monnaie)
        		capitalTotal += p.getMontant();
        
        return capitalTotal;

    }

    @Override
    public String toString() {
        String ret = "";
        for(PorteFeuille p : this.portefeuilles){
            ret += p.toString() + "\n";
        }
        return ret;
    }

}
