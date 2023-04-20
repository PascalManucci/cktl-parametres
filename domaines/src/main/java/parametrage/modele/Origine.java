package parametrage.modele;

public enum Origine {
    GRHUM("GRHUM"),
    GFC("GFC"),
    CLOUDCONFIG("CLOUDCONFIG");

    public String getCode() {
        return code;
    }
    private String code;

    private Origine(String code) {
        this.code = code == null ? null : String.valueOf(code);

    }









}
