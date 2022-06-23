package fr.iutlan20212022sae201lot3.sae201.donnees;

public enum NomCategorie {
    EMPLACEMENT_SIMPLE,
    MOBILHOME_STANDARD,
    MOBILHOME_GRAND_LUXE;

    @Override
    public String toString() {
        String resultat;

        switch (this) {
            case EMPLACEMENT_SIMPLE:
                resultat = "Emplacement Simple";
                break;

            case MOBILHOME_GRAND_LUXE:
                resultat = "Mobil-home Grand Luxe";
                break;

            case MOBILHOME_STANDARD:
                resultat = "Mobil-home Standard";
                break;

            default:
                resultat = "Inconnu";
                break;
        }

        return resultat;
    }
}
