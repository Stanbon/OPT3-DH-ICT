public interface Vechten {
    void valAan(Vechten doel);
    void ontvangSchade(int schade);
    String getNaam();
    boolean isVerslagen();
    int getHP();
}