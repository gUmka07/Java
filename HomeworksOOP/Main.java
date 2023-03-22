package domashka;

public class Main {

    public static void public static void main(String[] args) {
        
        Goods bread = new Bread("Любимый сухарик", 50.0, 5, "шт.", "2 недели", "Ржаной");
        Goods milk = new Milk("Томское молочко", 88.50, 2, "бут.", "3 месяца", 2.5, 1.0);
        Goods lemonade = new Lemonade("Добрый Кола", 100.0, 12, "бут.", 1.5);
        Goods eggs = new Eggs("Насест", 85.99, 1, "яч.", "10 дней", 10);
        Goods nipple = new Nipple("Малыш", 345.87, 200, "шт", 0, "да");
        Goods diapers = new Diapers("Подгузники 'Meris'", 1888.50, 5, "шт", 0, "да", "XS", 3, 4);
        Goods masks = new Masks("Маски", 150.0, 100, "шт", 10);
        Goods paper = new ToiletPaper("Туалетная бумага 'Zewa'", 109.0, 20, "шт", 4, 2);

        Goods[] goods = {bread, milk, lemonade, eggs, nipple, diapers, masks, paper};
        show(goods);

    }
        static void show(Goods [] goods){
            System.out.println("Все товары магазина\n");
            for (Goods item: goods) {
                System.out.println(item);
            }
        }
}