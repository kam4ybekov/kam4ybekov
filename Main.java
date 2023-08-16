public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.setHealth(500);
        boss.setDamage(50);
        boss.setDefenseType("sheild");

        System.out.println("Информация о боссе:");
        System.out.println("Здоровье: " + boss.getHealth());
        System.out.println("Урон: " + boss.getDamage());
        System.out.println("Тип защиты: " + boss.getDefenseType());

        Hero hero1 = new Hero(100, 20, "Летание");
        Hero hero2 = new Hero(150, 30);

        System.out.println("Информация о герое 1:");
        System.out.println("Здоровье: " + hero1.getHealth());
        System.out.println("Урон: " + hero1.getDamage());
        System.out.println("Суперспособность: " + hero1.getSuperpower());

        System.out.println("Информация о герое 2:");
        System.out.println("Здоровье: " + hero2.getHealth());
        System.out.println("Урон: " + hero2.getDamage());
        System.out.println("Суперспособность: " + hero2.getSuperpower());
    }
}