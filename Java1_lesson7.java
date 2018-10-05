//окормление котов из одной тарелки
public class Java1_lesson7 {

    public static void main(String[] args) {
        //тарелка
        Plate plate = new Plate(27);
        System.out.println(plate);
        //коты
        Cat [] cats = {new Cat("Barsik", 10),
                       new Cat("Murzik", 8),
                       new Cat("Boris", 11)};
        //кормлю котов
        for (Cat c : cats) {
            c.eat(plate);
            System.out.println(c);//инфа о коте
            System.out.println(plate);//что осталось в тарелке
        }
    }
    
}

class Cat {
    private String name;
    private int appetite;//сколько может съесть
    private boolean full;//сытость
    //накопитель еды внутри кота, на случай если
    //кормить кота можно будет частями
    private int foodsIn;//кол-во еды внутри кота

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        //по умолчанию кот голодный
        full = false;
        foodsIn = 0;
    }

    void eat(Plate plate) {
        if (plate.getFood() >= appetite)
        {//удалось покушать
          plate.dicreaseFood(appetite);
          full = true;
          foodsIn = appetite;//живот наполнился
        }
        else {//не удалось покушать
          full = false;  
        }
    }
    
    @Override
    public String toString() {
        return name+":"+
            "\n| full:  "+ (full?"well fed":"hungry")+
            "\n| appetite:  "+ appetite+
            "\n| foodsIn:  "+ foodsIn;
    }

}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    void dicreaseFood(int food) {
        if ((this.food -= food) < 0) this.food = 0;
    }

    //добавить еды
    void addFood(int food) {
        this.food += food;
    }
    
    int getFood (){
        return food;
    }
    
    @Override
    public String toString() {
        return "Food: " + food;
    }
}