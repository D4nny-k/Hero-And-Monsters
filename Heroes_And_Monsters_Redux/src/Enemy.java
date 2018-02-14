public interface Enemy{
    int getAttack();
    int getHealth();
    void updateHealth(int value);
    void resetHealth();
}