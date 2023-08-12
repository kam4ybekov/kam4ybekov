import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic"};
    public static String[] heroesNames = {"Warrior", "Mage", "Archer", "Medic"};
    public static int[] heroesHealth = {280, 270, 250, 300};
    public static int[] heroesDamage = {10, 15, 20, 0};
    public static int roundNumber;

    public static void main(String[] args) {
        showStatistics();
        while (!isGameOver()) {
            playRound();
        }
    }

    public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        bossAttack();
        heroesAttack();
        medicHeal();
        showStatistics();
    }

    public static void chooseBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefence = heroesAttackType[randomIndex];
    }

    public static void bossAttack() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] -= bossDamage;
                }
            }
        }
    }

    public static void heroesAttack() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0 && i != 3) {
                int damage = heroesDamage[i];
                if (heroesAttackType[i].equals(bossDefence)) {
                    Random random = new Random();
                    int coeff = random.nextInt(9) + 2;
                    damage *= coeff;
                    System.out.println("Critical damage: " + damage);
                }
                if (bossHealth - damage < 0) {
                    bossHealth = 0;
                } else {
                    bossHealth -= damage;
                }
            }
        }
    }

    public static void medicHeal() {
        if (heroesHealth[3] > 0) {
            for (int i = 0; i < heroesHealth.length; i++) {
                if (heroesHealth[i] > 0 && heroesHealth[i] < 100 && i != 3) {
                    heroesHealth[i] += 50;
                    if (heroesHealth[i] > 100) {
                        heroesHealth[i] = 100;
                    }
                }
            }
        }
    }

    public static void showStatistics() {
        System.out.println("ROUND " + roundNumber + " --------------");
        System.out.println("Boss health: " + bossHealth + " damage: " + bossDamage + " defence: " +
                (bossDefence == null ? "No Defence" : bossDefence));
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesNames[i] + " health: " + heroesHealth[i]
                    + " damage: " + heroesDamage[i]);
        }
    }

    public static boolean isGameOver() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && i != 3) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}
