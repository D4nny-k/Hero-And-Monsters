public interface Enemy{
    int getAttack();
    int getHealth();
    int getSpeed();
    void updateHealth(int value);
    void resetHealth();
}