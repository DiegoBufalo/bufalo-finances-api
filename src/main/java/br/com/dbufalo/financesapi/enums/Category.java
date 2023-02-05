package br.com.dbufalo.financesapi.enums;

public enum Category {

    GYM("Academia"),
    MARKET("Mercado"),
    ELECTRONIC_PARTS("Eletronico"),
    HAIR_CUT("Cabeleleiro"),
    GAMES("Jogo"),
    RECURRENT_PLAN("Plano Recorrênte"),
    OTHERS("Outros");

    private final String categoryDesc;


    public String getCategoryDesc() {
        return  this.categoryDesc;
    }

    Category(String desc) {
        this.categoryDesc = desc;
    }
}
